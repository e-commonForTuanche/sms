package com.tcw.mapper.smsdb.sys;

import java.util.List;

import com.tcw.modules.system.dto.BlackListDto;

public interface SysBlacklistInfoMapper {
	
	List<BlackListDto> selectList(BlackListDto blackListDto);
	
	BlackListDto selectListCount(BlackListDto blackListDto);
	
	int insertOne(BlackListDto blackListDto);
	
	int updateOne(BlackListDto blackListDto);
	
	int updateByArray(BlackListDto blackListDto);
}
