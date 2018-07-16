package com.framework.others;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.mysql.fabric.xmlrpc.base.Data;

/**
 *  ±º‰¿‡
 * @author Administrator
 *
 */
public class currentTime {
	
	public static String presentTime(){
		Data d=new Data();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(d);
	}
}
