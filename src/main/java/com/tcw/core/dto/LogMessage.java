package com.tcw.core.dto;

public class LogMessage {

	public static String VALIDATE_LOGIN         = "[SMS_LOG]>>>>>>>>>>>[验证登录缓存]";
	
	public static String FREE_VALIDATE_LOGIN    = "[SMS_LOG]>>>>>>>>>>>[登录免验证]";
	
	public static String LOGIN_SESSION_TIMEOUT  = "[SMS_LOG]>>>>>>>>>>>[登录][缓存超时]";
	
	public static String VALIDATE_LOGIN_SUCCESS = "[SMS_LOG]>>>>>>>>>>>[验证登录成功]";
	
	public static String LOGIN_ID_NULL          = "[SMS_LOG]>>>>>>>>>>>[登录][用户名参数为空]";
	
	public static String LOGIN_PW_NULL          = "[SMS_LOG]>>>>>>>>>>>[登录][{param}][密码参数为空]";
	
	public static String LOGIN_ID_NO_EXIST      = "[SMS_LOG]>>>>>>>>>>>[登录][{param}][用户不存在]";
	
	public static String LOGIN_PW_ERROR         = "[SMS_LOG]>>>>>>>>>>>[登录][{param}][用户密码错误]";
	
	public static String LOGIN_BIZ_CODE_ERROR   = "[SMS_LOG]>>>>>>>>>>>[登录][{param}][没有平台权限]";
	
	public static String getMessage(String message, String...params) {
		if (params.length + 1 == message.split("\\{param\\}").length) {
			int idx = 0;
			while (message.indexOf("{param}") > -1) {
				message = message.replaceFirst("\\{param\\}", params[idx]);
				idx++;
			}
		}
		return message;
	}
}
