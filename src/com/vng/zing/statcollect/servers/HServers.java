/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.statcollect.servers;

import com.vng.zing.jettyserver.WebServers;
import com.vng.zing.statcollect.handlers.DashboardServlet;
import com.vng.zing.statcollect.handlers.MinStatsPointHandler;
import com.vng.zing.statcollect.handlers.SecStatsPointHandler;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author namnq
 */
public class HServers {

	public boolean setupAndStart() {
		WebServers servers = new WebServers("statcollect");
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setWelcomeFiles(new String[] { "/layout/dashboard.html" });
        context.setResourceBase("./src/resources");
        
		context.addServlet(DashboardServlet.class, "/dashboard");
		context.addServlet(SecStatsPointHandler.class, "/sec_statspoint");
		context.addServlet(MinStatsPointHandler.class, "/min_statspoint");
        
        ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
        context.addServlet(holderPwd,"/*");
        
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {  context });
		servers.setup(handlers);
		return servers.start();
	}
}
