package com.tcw.mapper.smsdb.sys;

import java.util.List;

import com.tcw.modules.system.dto.WordListDto;

public interface SysWordInfoMapper {
	
	List<WordListDto> selectList(WordListDto wordListDto);
	
	WordListDto selectListCount(WordListDto wordListDto);
	
	int insertOne(WordListDto wordListDto);
	
	int updateOne(WordListDto wordListDto);
	
	int updateByArray(WordListDto wordListDto);
}
