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
public class MinStatsPoint extends StatsPoint{
	
	public MinStatsPoint(int totalReq, long totalTimeProc, long timestamp) {
		super(totalReq, totalTimeProc, timestamp);
	}
	public MinStatsPoint (Document doc){
		super(doc);
	}
}
