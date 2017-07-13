package com.tcw.modules.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcw.core.base.BaseController;
import com.tcw.core.dto.ResultDTO;
import com.tcw.modules.system.dto.BlackListDto;
import com.tcw.modules.system.service.BlackListService;

@Controller
@RequestMapping("/blackList")
public class BlackListController extends BaseController {

	
	@Autowired
	private BlackListService blackListService;
	
	@RequestMapping("/getList")
	@ResponseBody
	public ResultDTO<BlackListDto> selectList(BlackListDto blackListDto) {
		return blackListService.selectList(blackListDto);
	}
	
	@RequestMapping("/action")
	@ResponseBody
	public ResultDTO<String> action(BlackListDto blackListDto) {
		return blackListService.action(blackListDto);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ResultDTO<String> delete(BlackListDto blackListDto) {
		return blackListService.delete(blackListDto);
	}
}
