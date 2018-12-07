/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.statcollect.model;

import com.vng.zing.common.ZUtil;
import com.vng.zing.statcollect.common.DBConnect;
import com.vng.zing.statcollect.enities.StatsPoint;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author hagyhang
 */
public class StatsPointModel {
	private static String SECOND_URL = "http://localhost:9200/second/";
	private static String MINUTE_URL = "http://localhost:9200/minute/";
	private static int DELAY = 10; //delay time (second)
	private static int MAX_RANGE = 120;
	public static void pushStatsPoint(StatsPoint point, String name){
		String url = MINUTE_URL + name + "/" + point.timestamp/1000;
		DBConnect.sendPost(url, point.toJSONString());
	}
	
	public static void pushStatsPointInLimit(StatsPoint point, String name){
		String url = SECOND_URL + name + "/" + (point.timestamp/1000)%MAX_RANGE;
		DBConnect.sendPost(url, point.toJSONString());
	}
	
	public static List<StatsPoint> getMinStatsPoints(String name, int limit){
		List<StatsPoint> ret = new ArrayList<>();
		long startTime = System.currentTimeMillis()/1000 - limit*60 - DELAY;
		startTime *= 1000;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(startTime);
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + "h " + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
		String url = MINUTE_URL + name + "/_search";
		String query = "{\n" +
						"    \"query\": {\n" +
						"        \"range\" : {\n" +
						"            \"timestamp\" : {\n" +
						"                \"gte\" : "+ startTime + ",\n" +
						"                \"boost\" : 1.0\n" +
						"            }\n" +
						"        }\n" +
						"    },\n" +
						"    \"size\": " + limit + ",\n" +
						"    \"sort\": [\n" +
						"	    {\n" +
						"	      \"timestamp\": {\n" +
						"	        \"order\": \"asc\"\n" +
						"	      }\n" +
						"	    }\n" +
						"	 ]\n" +
						"}";
		String raw = DBConnect.sendPost(url, query);
		JSONArray hits = null;
		try{
			JSONObject jsonRaw = new JSONObject(raw);
			hits = jsonRaw.getJSONObject("hits").getJSONArray("hits");
		
			if (hits != null){
				for (int i = 0; i < hits.length(); i++) {
					JSONObject o = hits.getJSONObject(i).getJSONObject("_source");
					StatsPoint sp = new StatsPoint(o.getInt("totalReq"), 
							o.getLong("totalTimeProc"), o.getLong("timestamp"));
					ret.add(sp);
//					System.out.println(sp.toJSONString());
				}
			}
		} catch(JSONException e){
		}
		return ret;
	}
	
	public static List<StatsPoint> getMinStatsPoints(String name, int limit, int interval){
		List<StatsPoint> ret = new ArrayList<>();
		List<StatsPoint> list = new ArrayList<>();
		long current = System.currentTimeMillis()/1000 - DELAY;
		long startTime = current - limit*60 - current % interval;
		startTime *= 1000;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(startTime);
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + "h " + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
		String url = MINUTE_URL + name + "/_search";
		String query = "{\n" +
						"    \"query\": {\n" +
						"        \"range\" : {\n" +
						"            \"timestamp\" : {\n" +
						"                \"gte\" : "+ startTime + ",\n" +
						"                \"boost\" : 1.0\n" +
						"            }\n" +
						"        }\n" +
						"    },\n" +
						"    \"size\": " + limit + ",\n" +
						"    \"sort\": [\n" +
						"	    {\n" +
						"	      \"timestamp\": {\n" +
						"	        \"order\": \"asc\"\n" +
						"	      }\n" +
						"	    }\n" +
						"	 ]\n" +
						"}";
		String raw = DBConnect.sendPost(url, query);
		JSONArray hits = null;
		try{
			JSONObject jsonRaw = new JSONObject(raw);
			hits = jsonRaw.getJSONObject("hits").getJSONArray("hits");
		
			if (hits != null){
				for (int i = 0; i < hits.length(); i++) {
					JSONObject o = hits.getJSONObject(i).getJSONObject("_source");
					StatsPoint sp = new StatsPoint(o.getInt("totalReq"), 
							o.getLong("totalTimeProc"), o.getLong("timestamp"));
					list.add(sp);

				}
//				System.out.println("list size: " + list.size());
				StatsPoint statsPoint = new StatsPoint();
//				System.out.println(list.get(0).timestamp + "-+=+=+-" + list.get(list.size() - 1).timestamp);
				for (int i = 0; i < list.size(); i++) {
					StatsPoint temp = list.get(i);
					statsPoint.totalReq += temp.totalReq;
					statsPoint.totalTimeProc += temp.totalTimeProc;
					if (i % interval == interval - 1) {
						statsPoint.timestamp = temp.timestamp;
						ret.add(statsPoint);
						statsPoint = new StatsPoint();
					}	
				}
			}
		} catch(JSONException e){
		}
		return ret;
	}
	
	public static List<StatsPoint> getSecStatsPoints(String name, int limit){
		List<StatsPoint> ret = new ArrayList<>();
		long startTime = System.currentTimeMillis()/1000 - limit - DELAY;
		startTime *= 1000;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(startTime);
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + "h " + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
		String url = SECOND_URL + name + "/_search";
		String query = "{\n" +
						"    \"query\": {\n" +
						"        \"range\" : {\n" +
						"            \"timestamp\" : {\n" +
						"                \"gte\" : "+ startTime + ",\n" +
						"                \"boost\" : 1.0\n" +
						"            }\n" +
						"        }\n" +
						"    },\n" +
						"    \"size\": " + limit + ",\n" +
						"    \"sort\": [\n" +
						"	    {\n" +
						"	      \"timestamp\": {\n" +
						"	        \"order\": \"asc\"\n" +
						"	      }\n" +
						"	    }\n" +
						"	 ]\n" +
						"}";
		String raw = DBConnect.sendPost(url, query);
		JSONArray hits = null;
		try{
			JSONObject jsonRaw = new JSONObject(raw);
			hits = jsonRaw.getJSONObject("hits").getJSONArray("hits");
		
			if (hits != null){
				for (int i = 0; i < hits.length(); i++) {
					JSONObject o = hits.getJSONObject(i).getJSONObject("_source");
					StatsPoint sp = new StatsPoint(o.getInt("totalReq"), 
							o.getLong("totalTimeProc"), o.getLong("timestamp"));
					ret.add(sp);
//					System.out.println(sp.toJSONString());
				}
			}
		} catch(JSONException e){
		}
		return ret;
	}
	
	public static List<StatsPoint> getSecStatsPoints(String name, int limit, int interval){
		List<StatsPoint> ret = new ArrayList<>();
		List<StatsPoint> list = new ArrayList<>();
		long current = System.currentTimeMillis()/1000 - DELAY;
		long startTime = current - limit - current % interval;
		startTime *= 1000;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(startTime);
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + "h " + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
		String url = SECOND_URL + name + "/_search";
		String query = "{\n" +
						"    \"query\": {\n" +
						"        \"range\" : {\n" +
						"            \"timestamp\" : {\n" +
						"                \"gte\" : "+ startTime + ",\n" +
						"                \"boost\" : 1.0\n" +
						"            }\n" +
						"        }\n" +
						"    },\n" +
						"    \"size\": " + limit + ",\n" +
						"    \"sort\": [\n" +
						"	    {\n" +
						"	      \"timestamp\": {\n" +
						"	        \"order\": \"asc\"\n" +
						"	      }\n" +
						"	    }\n" +
						"	 ]\n" +
						"}";
		String raw = DBConnect.sendPost(url, query);
		JSONArray hits = null;
		try{
			JSONObject jsonRaw = new JSONObject(raw);
			hits = jsonRaw.getJSONObject("hits").getJSONArray("hits");
		
			if (hits != null){
				for (int i = 0; i < hits.length(); i++) {
					JSONObject o = hits.getJSONObject(i).getJSONObject("_source");
					StatsPoint sp = new StatsPoint(o.getInt("totalReq"), 
							o.getLong("totalTimeProc"), o.getLong("timestamp"));
					list.add(sp);

				}
//				System.out.println("list size: " + list.size());
				StatsPoint statsPoint = new StatsPoint();
//				System.out.println(list.get(0).timestamp + "-+=+=+-" + list.get(list.size() - 1).timestamp);
				for (int i = 0; i < list.size(); i++) {
					StatsPoint temp = list.get(i);
					statsPoint.totalReq += temp.totalReq;
					statsPoint.totalTimeProc += temp.totalTimeProc;
					if (i % interval == interval - 1) {
						statsPoint.timestamp = temp.timestamp;
						ret.add(statsPoint);
						statsPoint = new StatsPoint();
					}	
				}
			}
		} catch(JSONException e){
		}
		return ret;
	}
	
	public static void main(String[] args) {
		while (true){
			System.out.println("\n" + System.currentTimeMillis());
			List<StatsPoint> list = getMinStatsPoints("Thread-Update", 120, 1);
			System.out.print(list.size() + "total: ");
			for (StatsPoint statsPoint : list) {
				System.out.print(statsPoint.totalReq +", ");
			}
			System.out.println(" ");
			ZUtil.sleep(1000);
		}
		
	}
}
