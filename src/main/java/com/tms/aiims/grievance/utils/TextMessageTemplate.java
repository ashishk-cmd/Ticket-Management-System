package com.tms.aiims.grievance.utils;

public class TextMessageTemplate {

	public static String sendOTP(int otp, String purpose) {
		StringBuilder sb = new StringBuilder();
		sb.append(otp+" is the OTP to "+purpose+".");
		return sb.toString();
	}
	
}
