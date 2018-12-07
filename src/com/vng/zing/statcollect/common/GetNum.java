/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.statcollect.common;

import com.vng.zing.common.ZUtil;
import com.vng.zing.test.common.NewClass;

/**
 *
 * @author hagyhang
 */
public class GetNum {
	public static int getNum (){
		return NewClass.num;
	}
	public static void main(String[] args) {
		System.out.println(ZUtil.DefaultTimeZoneRawOffset);
	}
}
