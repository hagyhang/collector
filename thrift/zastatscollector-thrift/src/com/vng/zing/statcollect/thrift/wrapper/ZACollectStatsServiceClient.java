/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.statcollect.thrift.wrapper;

import com.vng.zing.common.ZCommonDef;
import com.vng.zing.common.ZErrorDef;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.statcollect.thrift.TMapStatPoint;
import com.vng.zing.statcollect.thrift.ZACollectStatsService;
import com.vng.zing.thriftpool.TClientPool;
import com.vng.zing.thriftpool.ZClientPoolUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author hagyhang
 */
public class ZACollectStatsServiceClient {

	private static final Class _ThisClass = ZACollectStatsServiceClient.class;
	private static final Logger _Logger = ZLogger.getLogger(_ThisClass);
	private final String _name;
	private TClientPool.BizzConfig _bizzCfg;

	public ZACollectStatsServiceClient(String name) {
		assert (name != null && !name.isEmpty());
		_name = name;
		_initialize();

	}

	private void _initialize() {
		ZClientPoolUtil.SetDefaultPoolProp(_ThisClass //clazzOfCfg
				,
				 _name //instName
				,
				 null //host
				,
				 null //auth
				,
				 ZCommonDef.TClientTimeoutMilisecsDefault //timeout
				,
				 ZCommonDef.TClientNRetriesDefault //nretry
				,
				 ZCommonDef.TClientMaxRdAtimeDefault //maxRdAtime
				,
				 ZCommonDef.TClientMaxWrAtimeDefault //maxWrAtime
		);
		ZClientPoolUtil.GetListPools(_ThisClass, _name, new ZACollectStatsService.Client.Factory()); //auto create pools
		_bizzCfg = ZClientPoolUtil.GetBizzCfg(_ThisClass, _name);
	}

	private TClientPool<ZACollectStatsService.Client> getClientPool() {
		return (TClientPool<ZACollectStatsService.Client>) ZClientPoolUtil.GetPool(_ThisClass, _name);
	}

	private TClientPool.BizzConfig getBizzCfg() {
		return _bizzCfg;
	}

	private static void Log(Priority level, Throwable t) {
		_Logger.log(level, null, t);
	}

	private static void Log(Priority level, Throwable t, int retry) {
		if (retry > 0) {
			String message = "Request's still failed at retry " + retry;
			_Logger.log(level, message, t);
		} else {
			_Logger.log(level, null, t);
		}
	}

	///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/// error objects: spec ZPRawApiPageCommunication
	///
	///e1001: NO_CONNECTION
	//..
	public static final int NO_CONNECTION = ZErrorDef.NO_CONNECTION;
	///e1002: BAD_CONNECTION
	//..
	public static final int BAD_CONNECTION = ZErrorDef.BAD_CONNECTION;
	///e1003: BAD_REQUEST
	//..
	public static final int BAD_REQUEST = ZErrorDef.BAD_REQUEST;

	///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/// spec ZaPhotoReadService
	///
	public int pushStatsPeriod(TMapStatPoint mapStatPoint) {
		TClientPool<ZACollectStatsService.Client> pool = getClientPool();
		for (int retry = 0; retry < pool.getNRetry(); ++retry) {
			ZACollectStatsService.Client cli = pool.borrowClient();
			if (cli == null) {
				return ZErrorDef.NO_CONNECTION;
			}
			try {
				int ret = cli.pushMapStatPoint(mapStatPoint);
				pool.returnClient(cli);
				return ret;
			} catch (TTransportException ex) {
				pool.invalidateClient(cli, ex);
				Log(Priority.ERROR, ex, retry);
				continue;
			} catch (TException ex) {
				pool.invalidateClient(cli, ex);
				Log(Priority.ERROR, ex, retry);
				return ZErrorDef.BAD_REQUEST;
			} catch (Exception ex) {
				pool.invalidateClient(cli, ex);
				Log(Priority.ERROR, ex, retry);
				return ZErrorDef.BAD_REQUEST;
			}
		}
		return ZErrorDef.BAD_CONNECTION;
	}
}
