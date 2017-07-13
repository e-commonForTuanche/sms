package com.tcw.core.sms.service;

import com.tcw.core.sms.dto.GatewayInfoDto;
import com.tcw.core.sms.dto.RecordInfoDto;
import com.tcw.core.sms.impl.SMSAbstractService;

public class ZhutongSMSService extends SMSAbstractService {

	public void init(GatewayInfoDto gatewayInfoDto) {
		super.init(gatewayInfoDto);
	}
	
	public void sendOneMessage(RecordInfoDto recordInfoDto) {
		System.out.println(super.getHtmlUrl());
	}
}
