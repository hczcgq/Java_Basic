package com.chen.match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author chenguoquan
 *
 */
public class Match {
	

	public static void main(String[] args) {
		System.out.println(checkMobile("18516276648"));
	}

	/**
	 * 是否是手机号
	 * @param string
	 * @return
	 */
	private static boolean checkMobile(String mobile) {
		try {
			Pattern pattern=Pattern.compile("(13[0-9]|14[57]|15[012356789]|18[02356789])\\d{8}");
			Matcher matcher=pattern.matcher(mobile);
			return matcher.matches();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 检测邮箱地址是否正确
	 * @param mail
	 * @return
	 */
	private static boolean checkEmail(String mail){
		try {
			String format="([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";
			Pattern pattern=Pattern.compile(format);
			Matcher matcher=pattern.matcher(mail);
			return matcher.matches();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 检测是否包含字符串
	 * @param string
	 * @return
	 */
	private static boolean checkChinese(String string) {
		try {
			String format="[//u4E00-//u9FA5//uF900-//uFA2D]";
			Pattern pattern=Pattern.compile(format);
			Matcher matcher=pattern.matcher(string);
			return matcher.matches();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 检测字符串中只能包含：中文、数字、下划线(_)、横线(-)
	 * @param string
	 * @return
	 */
	private static boolean checkNickName(String string) {
		try {
			String format="[^//u4E00-//u9FA5//uF900-//uFA2D//w-_]";
			Pattern pattern=Pattern.compile(format);
			Matcher matcher=pattern.matcher(string);
			return matcher.matches();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
