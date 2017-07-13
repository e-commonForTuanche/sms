package com.tcw.core.sms.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tcw.core.sms.dto.GatewayInfoDto;
import com.tcw.core.sms.dto.RecordInfoDto;

public abstract class SMSAbstractService implements SMSServiceImpl {

	private String htmlUrl;
	
	public void init(GatewayInfoDto gatewayInfoDto) {
		this.htmlUrl = gatewayInfoDto.getHttpUrl() + "?";
		LinkedHashMap<String, String> jsonMap = JSON.parseObject(gatewayInfoDto.getHttpParamJson(), new TypeReference<LinkedHashMap<String, String>>() {});
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
        	this.htmlUrl += entry.getKey() + "=" + entry.getValue() + "&";
        }
	}
	
	public String getHtmlUrl() {
		return this.htmlUrl;
	}
	
	public void sendOneMessage(RecordInfoDto recordInfoDto) {
		
	}
	
	public void sendBatchMessage(RecordInfoDto recordInfoDto) {
		
	}
	
	public void receive(RecordInfoDto recordInfoDto) {
		
	}
}
