/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.statcollect.handlers;

import com.vng.zing.statcollect.enities.StatsPoint;
import com.vng.zing.statcollect.model.StatsPointModel;
import com.vng.zing.statcollect.thrift.TMapStatPoint;
import com.vng.zing.statcollect.thrift.ZACollectStatsService;
import com.vng.zing.zcommon.thrift.ECode;
import org.apache.thrift.TException;

/**
 *
 * @author hagyhang
 */
public class CollectStatsMWHandler implements ZACollectStatsService.Iface {

	@Override
	public int pushMapStatPoint(TMapStatPoint mapStatPoint) throws TException {
		int ret = ECode.EXCEPTION.getValue();
		mapStatPoint.secondMap.forEach((key, value) -> {
			StatsPoint point = new StatsPoint(value.totalReq, value.totalTimeProc, value.timestamp);
			StatsPointModel.pushStatsPointInLimit(point, key);
		});
		mapStatPoint.minuteMap.forEach((key, value) -> {
			StatsPoint point = new StatsPoint(value.totalReq, value.totalTimeProc, value.timestamp);
			StatsPointModel.pushStatsPoint(point, key);
		});
		return ret;
	}

}
