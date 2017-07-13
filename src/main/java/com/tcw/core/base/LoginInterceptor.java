package com.tcw.core.base;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tcw.core.anno.NoValidateLoginAuth;
import com.tcw.core.dto.LogMessage;
import com.tcw.core.utils.SessionUtils;
import com.tcw.modules.login.dto.UserInfoDto;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	private Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		log.info(LogMessage.VALIDATE_LOGIN);
		final HandlerMethod handlerMethod = (HandlerMethod) handler;
		final Method method = handlerMethod.getMethod();
		final Class<?> clazz = method.getDeclaringClass();
		
		if (!clazz.isAnnotationPresent(NoValidateLoginAuth.class) && !method.isAnnotationPresent(NoValidateLoginAuth.class)) {
			
			UserInfoDto userInfoDto = SessionUtils.getSessionUser();
			
			if (StringUtils.isEmpty(userInfoDto.getLoginId())) {
				response.sendRedirect(request.getContextPath()+"/");
				log.info(LogMessage.LOGIN_SESSION_TIMEOUT);
				return false;
			} else {
				log.info(LogMessage.VALIDATE_LOGIN_SUCCESS);
				return true;
			}
		} else {
			log.info(LogMessage.FREE_VALIDATE_LOGIN);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
