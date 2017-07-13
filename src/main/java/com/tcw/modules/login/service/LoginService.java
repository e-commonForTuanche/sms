package com.tcw.modules.login.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.tcw.core.dto.Constants;
import com.tcw.core.dto.LogMessage;
import com.tcw.core.dto.ResultDTO;
import com.tcw.core.dto.commonEnum.RtnEnum;
import com.tcw.core.utils.SessionUtils;
import com.tcw.mapper.erp.login.TCustomerEmployeeMapper;
import com.tcw.modules.login.dto.UserInfoDto;

@Service
public class LoginService {
	
	private Logger log = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private TCustomerEmployeeMapper loginMapper;
	
	public ResultDTO<UserInfoDto> validate(UserInfoDto userInfoDto) {
		ResultDTO<UserInfoDto> result = new ResultDTO<UserInfoDto>();
		
		result = validateUser(userInfoDto);
		
		if (!RtnEnum.SUCCESS.getCode().equals(result.getRtnCode())) {
			return result;
		}
		
		SessionUtils.setSessionUser(result.getRows().get(0));
		return result;
	}
	
	private ResultDTO<UserInfoDto> validateUser(UserInfoDto paramUserInfoDto) {
		ResultDTO<UserInfoDto> result = new ResultDTO<UserInfoDto>();
		
		if (paramUserInfoDto == null) {
			// 缓存超时
			result.setRtnCode(RtnEnum.SESSION_TIMEOUT.getCode());
			result.setRtnMesg(RtnEnum.SESSION_TIMEOUT.getMessage());
			log.debug(LogMessage.LOGIN_SESSION_TIMEOUT);
			return result;
		} else if (StringUtils.isEmpty(paramUserInfoDto.getLoginId())) {
			// 用户名参数为空
			result.setRtnCode(RtnEnum.LOGIN_ID_NULL.getCode());
			result.setRtnMesg(RtnEnum.LOGIN_ID_NULL.getMessage());
			log.debug(LogMessage.LOGIN_ID_NULL);
			return result;
		} else if (StringUtils.isEmpty(paramUserInfoDto.getLoginPw())) {
			// 用户密码参数为空
			result.setRtnCode(RtnEnum.LOGIN_PW_NULL.getCode());
			result.setRtnMesg(RtnEnum.LOGIN_PW_NULL.getMessage());
			log.debug(LogMessage.getMessage(LogMessage.LOGIN_PW_NULL, paramUserInfoDto.getLoginId()));
			return result;
		}
		
		List<UserInfoDto> list = loginMapper.selectList(paramUserInfoDto);
		
		if (list == null || list.isEmpty()) {
			// 用户不存在
			result.setRtnCode(RtnEnum.LOGIN_ID_NO_EXIST.getCode());
			result.setRtnMesg(RtnEnum.LOGIN_ID_NO_EXIST.getMessage());
			log.debug(LogMessage.getMessage(LogMessage.LOGIN_ID_NO_EXIST, paramUserInfoDto.getLoginId()));
			return result;
		}
		
		UserInfoDto userInfoDto = list.get(0);
		
		if (!paramUserInfoDto.getLoginPw().equals(userInfoDto.getLoginPw())) {
			// 用户密码错误
			result.setRtnCode(RtnEnum.LOGIN_PW_ERROR.getCode());
			result.setRtnMesg(RtnEnum.LOGIN_PW_ERROR.getMessage());
			log.debug(LogMessage.getMessage(LogMessage.LOGIN_PW_ERROR, paramUserInfoDto.getLoginId()));
			return result;
		}
		
		if (!userInfoDto.getBizCode().contains(Constants.LOGIN_BASIC_CODE)) {
			// 没有平台权限
			result.setRtnCode(RtnEnum.LOGIN_BIZ_CODE_ERROR.getCode());
			result.setRtnMesg(RtnEnum.LOGIN_BIZ_CODE_ERROR.getMessage());
			log.debug(LogMessage.getMessage(LogMessage.LOGIN_BIZ_CODE_ERROR, paramUserInfoDto.getLoginId()));
			return result;
		}
		
		result.setRows(list);
		result.setRtnCode(RtnEnum.SUCCESS.getCode());
		result.setRtnMesg(RtnEnum.SUCCESS.getMessage());
		return result;
	}
}
