package com.tcw.modules.system.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.tcw.core.dto.Constants;
import com.tcw.core.dto.ResultDTO;
import com.tcw.core.dto.commonEnum.RtnEnum;
import com.tcw.mapper.smsdb.sys.SysBlacklistInfoMapper;
import com.tcw.modules.system.dto.BlackListDto;

@Service
public class BlackListService {
	
	@Autowired
	private SysBlacklistInfoMapper sysBlacklistInfoMapaper;

	public ResultDTO<BlackListDto> selectList(BlackListDto blackListDto) {
		ResultDTO<BlackListDto> result = new ResultDTO<BlackListDto>();
		
		int page = blackListDto.getPage() == 0 ? 1 : blackListDto.getPage();
		int rows = blackListDto.getRows() == 0 ? 1 : blackListDto.getRows();
		PageHelper.startPage(page, rows);

		List<BlackListDto> list = sysBlacklistInfoMapaper.selectList(blackListDto);
		result.setRows(list);
		
		BlackListDto countDto = sysBlacklistInfoMapaper.selectListCount(blackListDto);
		result.setTotal(countDto.getTotal());
		
		return result;
	}
	
	public ResultDTO<String> action(BlackListDto blackListDto) {
		ResultDTO<String> result = new ResultDTO<String>();
		String rtnMesg = "";
		
		if (blackListDto == null || StringUtils.isEmpty(blackListDto.getPhone())) {
			// 参数为空
			result.setRtnCode(RtnEnum.PARAMETER_NULL.getCode());
			result.setRtnMesg(RtnEnum.PARAMETER_NULL.getMessage());
			return result;
		}
		
		boolean isExist = isExist(blackListDto);
		
		if (isExist) {
			result.setRtnCode(RtnEnum.DATA_EXIST.getCode());
			result.setRtnMesg("[" + blackListDto.getPhone() + "]" +RtnEnum.DATA_EXIST.getMessage());
			return result;
		}
		
		boolean isCreate = blackListDto.getId() == 0 ? true : false;
		Date date = new Date();
		int userId = 1;
		if (isCreate) {
			// 新建
			blackListDto.setCreateDt(date);
			blackListDto.setCreateId(userId);
			sysBlacklistInfoMapaper.insertOne(blackListDto);
		} else {
			// 更新
			blackListDto.setUpdateDt(date);
			blackListDto.setUpdateId(userId);
			sysBlacklistInfoMapaper.updateOne(blackListDto);
		}
		
		result.setRtnCode(RtnEnum.SUCCESS.getCode());
		result.setRtnMesg(rtnMesg);
		
		return result;
	}
	
	protected boolean isExist(BlackListDto blackListDto) {
		
		List<BlackListDto> list = sysBlacklistInfoMapaper.selectList(blackListDto);
		
		if (list != null && !list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public ResultDTO<String> delete(BlackListDto blackListDto) {
		ResultDTO<String> result = new ResultDTO<String>();
		
		if (blackListDto != null && blackListDto.getIdArray() != null && blackListDto.getIdArray().length > 0) {
			int userId = 1;
			blackListDto.setUpdateDt(new Date());
			blackListDto.setUpdateId(userId);
			blackListDto.setDeleteTag(Constants.STATIC_ONE);
			sysBlacklistInfoMapaper.updateByArray(blackListDto);
			
			result.setRtnCode(RtnEnum.SUCCESS.getCode());
			result.setRtnMesg(RtnEnum.SUCCESS.getMessage());
		} else {
			result.setRtnCode(RtnEnum.PARAMETER_NULL.getCode());
			result.setRtnMesg(RtnEnum.PARAMETER_NULL.getMessage());
		}
		
		
		return result;
	}
}
