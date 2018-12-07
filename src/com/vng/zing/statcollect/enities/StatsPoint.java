/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.statcollect.enities;

import com.google.gson.Gson;
import com.vng.zing.stats.dt.PeakInfo;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.json.simple.JSONObject;

/**
 *
 * @author hagyhang
 */
public class StatsPoint {
	public int totalReq = 0;
	public long totalTimeProc = 0; 
	public long timestamp = 0;
//	public final PeakInfo peakTimeProc = new PeakInfo(); //timespan in micro-second //no-final for pooling object
//	public final PeakInfo peakPendingReq = new PeakInfo();

	public StatsPoint(int totalReq, long totalTimeProc, long timestamp) {
		this.totalReq = totalReq;
		this.totalTimeProc = totalTimeProc;
		this.timestamp = timestamp;
	}
	
	public StatsPoint (Document doc){
		try{
			this.timestamp = doc.getLong("timestamp");
			this.totalReq = doc.getInteger("totalReq");
			this.totalTimeProc = doc.getLong("totalTimeProc");
		} catch (Exception e) {
		}
	}

	public StatsPoint() {
		
	}
	public final float getProcRate() {
		if (totalTimeProc == 0) {
			return 0.0f;
		}
		return (float) ((totalReq * 1000000.0d) / totalTimeProc);
	}
	
	/**
	 * average time-proc a req in microsecond
	 *
	 * @return
	 */
	public final int getAvgTimeProc() {
		if (totalReq == 0) {
			return 0;
		}
		return (int) (totalTimeProc / totalReq);
	}

	/**
	 * per second average of req-rate
	 *
	 * @return
	 */
	public float getAvgReqRate() {
		return totalReq; //assume that this is in SECOND period
	}

	//
	////////////////////////////////////////////////////////////////////////////
	//
	public void clear() {
		totalReq = 0;
		totalTimeProc = 0;
		timestamp = 0;
//		peakTimeProc.clear();
//		peakPendingReq.clear();
	}
	
	public Map<String, Object>  toMap(){
				Map<String, Object> mapResult = new HashMap<>();
		try {
			
			Field[] fields = this.getClass().getFields();
			for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					mapResult.put(field.getName(), field.get(this));
			}
		} catch (IllegalArgumentException ex) {
			Logger.getLogger(StatsPoint.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(StatsPoint.class.getName()).log(Level.SEVERE, null, ex);
		}
		return mapResult;
	}
	
	public JSONObject toHChartData(){
		JSONObject o = new JSONObject();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		o.put("name", hour + "h " + minute + ":" + second);
		o.put("y", totalReq);
		return o;
	}
	
	public String toJSONString (){
		return new Gson().toJson(this);
	}
}
