package com.tcw.core.sms.impl;

import com.tcw.core.sms.dto.GatewayInfoDto;
import com.tcw.core.sms.dto.RecordInfoDto;

public interface SMSServiceImpl {

	void init(GatewayInfoDto gatewayInfoDto);
	
	void sendOneMessage(RecordInfoDto recordInfoDto);
	
	void sendBatchMessage(RecordInfoDto recordInfoDto);
	
	void receive(RecordInfoDto recordInfoDto);
}