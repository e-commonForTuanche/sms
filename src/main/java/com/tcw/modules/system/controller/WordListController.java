package com.tcw.modules.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcw.core.base.BaseController;
import com.tcw.core.dto.ResultDTO;
import com.tcw.modules.system.dto.WordListDto;
import com.tcw.modules.system.service.WordListService;

@Controller
@RequestMapping("/wordList")
public class WordListController extends BaseController {

	
	@Autowired
	private WordListService wordListService;
	
	@RequestMapping("/getList")
	@ResponseBody
	public ResultDTO<WordListDto> selectList(WordListDto blackListDto) {
		return wordListService.selectList(blackListDto);
	}
	
	@RequestMapping("/action")
	@ResponseBody
	public ResultDTO<String> action(WordListDto blackListDto) {
		return wordListService.action(blackListDto);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ResultDTO<String> delete(WordListDto blackListDto) {
		return wordListService.delete(blackListDto);
	}
}
