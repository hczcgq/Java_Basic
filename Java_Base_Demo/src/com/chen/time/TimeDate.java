package com.chen.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDate {
	private static final String format1="yyyy-MM-dd HH:mm:ss";
	private static final String format2="yyyy-MM-dd";
	private static final String format3="HH:mm:ss";
	private static final String format4="yyyy-MM";
	private static final String format5="yyyy";
	private static final String format6="mm:ss";
	private static final String format7="yyyy年MM月dd日";
	private static final String format8="yyyy年MM月dd日 HH时mm分ss秒";
	

	public static void main(String[] args) {
		System.out.println(getCurrentDateString(format1));
		System.out.println(getCurrentDateString(format2));
		System.out.println(getCurrentDateString(format3));
		System.out.println(getCurrentDateString(format4));
		System.out.println(getCurrentDateString(format5));
		System.out.println(getCurrentDateString(format6));
		System.out.println(getCurrentDateString(format7));
		System.out.println(getCurrentDateString(format8));
		
		System.err.println("-----------------------------------");
		System.err.println(getCurrentDate());
		System.err.println(getCurrentDateString(format1));
		System.err.println(stringToDate(getCurrentDateString(format1)));
		System.err.println(dateToString(getCurrentDate()));
		
	}
	
	/**
	 * 获取当前日期Date
	 * @return
	 */
	private static Date getCurrentDate() {
		return new Date();
	}
	

	/**
	 * 获取当前日期字符串
	 * @param format 
	 * @return  2016-05-18 14:38:03
	 */
	private static String getCurrentDateString(String format) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	/**
	 * 日期字符串转换为Date
	 * @param string
	 * @return
	 */
	private static Date stringToDate(String string){
		SimpleDateFormat format=new SimpleDateFormat(format1);
		try {
			return format.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Date转换为日期字符串
	 * @param date
	 * @return
	 */
	private static String dateToString(Date date){
		SimpleDateFormat format=new SimpleDateFormat(format2);
		return format.format(date);
	}
	
	
	
	
}
