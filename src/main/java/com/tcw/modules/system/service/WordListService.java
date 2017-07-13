package com.tcw.modules.system.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.tcw.core.dto.Constants;
import com.tcw.core.dto.ResultDTO;
import com.tcw.core.dto.commonEnum.RtnEnum;
import com.tcw.core.dto.commonEnum.WordEnum;
import com.tcw.mapper.smsdb.sys.SysWordInfoMapper;
import com.tcw.modules.system.dto.WordListDto;

@Service
public class WordListService {
	
	@Autowired
	private SysWordInfoMapper sysWordInfoMapaper;

	public ResultDTO<WordListDto> selectList(WordListDto wordListDto) {
		ResultDTO<WordListDto> result = new ResultDTO<WordListDto>();
		
		int page = wordListDto.getPage() == 0 ? 1 : wordListDto.getPage();
		int rows = wordListDto.getRows() == 0 ? 1 : wordListDto.getRows();
		PageHelper.startPage(page, rows);

		List<WordListDto> list = sysWordInfoMapaper.selectList(wordListDto);
		result.setRows(list);
		
		WordListDto countDto = sysWordInfoMapaper.selectListCount(wordListDto);
		result.setTotal(countDto.getTotal());
		
		return result;
	}
	
	public ResultDTO<String> action(WordListDto wordListDto) {
		ResultDTO<String> result = new ResultDTO<String>();
		String rtnMesg = "";
		
		if (wordListDto == null || StringUtils.isEmpty(wordListDto.getWord())) {
			// 参数为空
			result.setRtnCode(RtnEnum.PARAMETER_NULL.getCode());
			result.setRtnMesg(RtnEnum.PARAMETER_NULL.getMessage());
			return result;
		}
		
		Set<String> existWords = validate(wordListDto);
		String[] words = wordListDto.getWord().substring(1, wordListDto.getWord().length() - 1).split("\\|");
		
		if (!existWords.isEmpty() && existWords.size() <= words.length) {
			if (existWords.size() == words.length) {
				// 全部重复数据
				result.setRtnCode(RtnEnum.DATA_EXIST.getCode());
				result.setRtnMesg("[" + wordListDto.getWord() + "]" +RtnEnum.DATA_EXIST.getMessage());
				return result;
			} else {
				// 部分重复数据
				Iterator<String> word = existWords.iterator();
				wordListDto.setWord(wordListDto.getWord().substring(1));
				String tempWord;
				while (word.hasNext()) {
					tempWord = word.next();
					wordListDto.setWord(wordListDto.getWord().replace(tempWord + "|", ""));
					rtnMesg += tempWord + "|";
				}
				wordListDto.setWord("|" + wordListDto.getWord());
				rtnMesg = "|" + rtnMesg;
			}
		}
		
		boolean isCreate = wordListDto.getId() == 0 ? true : false;
		Date date = new Date();
		int userId = 1;
		if (isCreate) {
			// 新建
			wordListDto.setWordType(WordEnum.WORD_TYPE_WT00.getCode());
			wordListDto.setCreateDt(date);
			wordListDto.setCreateId(userId);
			sysWordInfoMapaper.insertOne(wordListDto);
		} else {
			// 更新
			wordListDto.setUpdateDt(date);
			wordListDto.setUpdateId(userId);
			sysWordInfoMapaper.updateOne(wordListDto);
		}
		
		result.setRtnCode(RtnEnum.SUCCESS.getCode());
		result.setRtnMesg(rtnMesg);
		
		return result;
	}
	
	protected Set<String> validate(WordListDto wordListDto) {
		
		Set<String> result = new HashSet<String>();
		String[] words = wordListDto.getWord().substring(1, wordListDto.getWord().length() - 1).split("\\|");
		wordListDto.setWordArray(words);
		
		List<WordListDto> list = sysWordInfoMapaper.selectList(wordListDto);
		
		if (list != null && !list.isEmpty()) {
			for (WordListDto wordDto : list) {
				if (!StringUtils.isEmpty(wordDto.getWord())) {
					for (String word : wordDto.getWord().substring(1, wordDto.getWord().length() - 1).split("\\|")) {
						if (wordListDto.getWord().contains("|" + word + "|")) {
							result.add(word);
						}
					}
				}
			}
		}
		
		return result;
	}
	
	public ResultDTO<String> delete(WordListDto wordListDto) {
		ResultDTO<String> result = new ResultDTO<String>();
		
		if (wordListDto != null && wordListDto.getIdArray() != null && wordListDto.getIdArray().length > 0) {
			int userId = 1;
			wordListDto.setUpdateDt(new Date());
			wordListDto.setUpdateId(userId);
			wordListDto.setDeleteTag(Constants.STATIC_ONE);
			sysWordInfoMapaper.updateByArray(wordListDto);
			
			result.setRtnCode(RtnEnum.SUCCESS.getCode());
			result.setRtnMesg(RtnEnum.SUCCESS.getMessage());
		} else {
			result.setRtnCode(RtnEnum.PARAMETER_NULL.getCode());
			result.setRtnMesg(RtnEnum.PARAMETER_NULL.getMessage());
		}
		
		
		return result;
	}
}
