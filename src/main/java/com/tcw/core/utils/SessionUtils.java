package com.tcw.core.utils;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tcw.core.dto.Constants;
import com.tcw.modules.login.dto.UserInfoDto;

public class SessionUtils {
	
	public static HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}
	
	public static Object getAttribute(String key) {
		return getSession().getAttribute(key);
	}
	
	private static void setAttribute(String key, Object value) {
		getSession().setAttribute(key, value);
	}
	private static void remove(String key) {
		getSession().removeAttribute(key);
	}
	
	/**
	 * 获取用户姓名
	 * @return
	 */
	public static String getUserName(){
		return getSessionUser().getUserName();
	}
	/**
	 * 获取用户编号
	 * @return
	 */
	public static int getUserId(){
		return getSessionUser().getUserId();
	}
	
	public static void setSessionUser(UserInfoDto userInfoDto) {
		if (getUserId() == 0) {
			remove(Constants.SESSION_BASE_NAME);
		}
		setAttribute(Constants.SESSION_BASE_NAME, userInfoDto);
	}
	
	public static UserInfoDto getSessionUser() {
		UserInfoDto userInfoDto = (UserInfoDto)getSession().getAttribute(Constants.SESSION_BASE_NAME);
		if (userInfoDto == null) {
			return new UserInfoDto();
		} else {
			return userInfoDto;
		}
	}
}
