/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.statcollect.enities;

import org.bson.Document;

/**
 *
 * @author hagyhang
 */
public class HourStatsPoint extends MinStatsPoint{
	
	public HourStatsPoint(int totalReq, long totalTimeProc, long timestamp) {
		super(totalReq, totalTimeProc, timestamp);
	}
	public HourStatsPoint (Document doc){
		super(doc);
	}
}
