/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.statcollect.handlers;

import com.vng.zing.statcollect.enities.StatsPoint;
import com.vng.zing.statcollect.model.StatsPointModel;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author hagyhang
 */
public class MinStatsPointHandler extends HttpServlet{
	@Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response ) throws ServletException,
                                                        IOException{
		
		JSONObject o = new JSONObject();
		JSONArray arr = new JSONArray();
		int limit = Integer.parseInt(request.getParameter("limit"));
		int interval = Integer.parseInt(request.getParameter("interval"));
		String name = request.getParameter("name");
		interval = 1;
		List<StatsPoint> list;
		if (interval == 1){
			list = StatsPointModel.getMinStatsPoints(name, limit);
		} else {
			list = StatsPointModel.getMinStatsPoints(name, limit, interval);
		}
		for (StatsPoint p : list) {
			arr.add(p.toHChartData());
			System.out.print(p.timestamp + ", ");
		}
		System.out.println(" ");
		o.put("points", arr);
		ServletOutputStream out = response.getOutputStream();
		out.write(o.toJSONString().getBytes(StandardCharsets.UTF_8));
		response.setHeader("Content-Type", "application/json");
		response.setStatus(200);
    }
	
	public static void main(String[] args) {
		JSONObject o = new JSONObject();
		JSONArray arr = new JSONArray();
//		List<StatsPoint> list = DBConnect.getStatsPoints(10, "Thread-Update");
//		for (StatsPoint p : list) {
//			arr.add(p.toHChartData());
//		}
		o.put("points", arr);
		System.out.println(o.toJSONString());
	}
}
