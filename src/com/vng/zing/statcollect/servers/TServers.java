/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.statcollect.servers;

import com.vng.zing.calc.thrift.Calc;
import com.vng.zing.statcollect.handlers.CollectStatsMWHandler;
import com.vng.zing.statcollect.thrift.ZACollectStatsService;
import com.vng.zing.thriftserver.ThriftServers;

/**
 *
 * @author namnq
 */
public class TServers {

	public boolean setupAndStart() {
		ThriftServers servers = new ThriftServers("statcollect");
		ZACollectStatsService.Processor processor = new ZACollectStatsService.Processor(new CollectStatsMWHandler());
		servers.setup(processor);
//		Calc.Processor processor = new Calc.Processor(new TCalcHandler());
//		servers.setup(processor);
		return servers.start();
	}
}
