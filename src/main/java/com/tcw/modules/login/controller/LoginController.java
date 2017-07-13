package com.tcw.modules.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcw.core.anno.NoValidateLoginAuth;
import com.tcw.core.dto.ResultDTO;
import com.tcw.modules.login.dto.UserInfoDto;
import com.tcw.modules.login.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@NoValidateLoginAuth
	@RequestMapping("/validate")
	@ResponseBody
	public ResultDTO<UserInfoDto> validate(String loginId, String loginPw) {
		return loginService.validate(new UserInfoDto(loginId, loginPw));
	}
}
