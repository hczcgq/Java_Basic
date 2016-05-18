package com.chen.string;

public class StringFormat {

	
	public static void main(String[] args) {
		System.out.println(getPhonePass("18516276648"));
	}
	
	/**
	 * 手机号中间有*号的手机号
	 * @param phone
	 * @return
	 */
	private static String getPhonePass(String phone){
		if(null==phone||"".equals(phone)||phone.length()<11){
			return "";
		}
		String passA=phone.substring(0, 3);
		String passB=phone.substring(phone.length()-3,phone.length());
		return passA+"****"+passB;
	}
	
	/**
	 * 身份证号中间加*
	 * @param pid
	 * @return
	 */
	public static String getPidPass(String pid) {
	    if (null == pid || "".equals(pid) || pid.length() < 18) {
	        return "";
	    }
	 
	    String passA = pid.substring(0, 3);
	    String passB = pid.substring(pid.length() - 3, pid.length());
	    return passA + "*****" + passB;
	}

}
