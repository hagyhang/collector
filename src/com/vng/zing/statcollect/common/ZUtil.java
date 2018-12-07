/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.statcollect.common;

/**
 *
 * @author hagyhang
 */
public class ZUtil extends com.vng.zing.common.ZUtil{
	public static String genKey (String name, boolean isThreadStats){
		return isThreadStats ? "Thread-" + name : "Api-" + name;
	}
}
