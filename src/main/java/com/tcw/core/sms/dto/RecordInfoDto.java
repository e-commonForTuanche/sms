package com.tcw.core.sms.dto;

import java.util.Date;

public class RecordInfoDto {

	/**ID主键*/
	private int id;

	/**短信服务的短信消息ID*/
	private String smsMsgId;

	/**发送手机号*/
	private String phone;

	/**内容ID*/
	private int contentId;

	/**是否为批次任务*/
	private String isBatch;

	/**批次ID*/
	private int batchId;

	/**定时任务ID*/
	private int taskId;

	/**短信网关消息ID*/
	private String gatewayMsgId;

	/**有效时间(秒数)*/
	private int expiryTime;

	/**城市ID*/
	private int cityId;

	/**定时发送时间*/
	private Date delayedSendDt;

	/**执行时间*/
	private Date executeSendDt;

	/**备注*/
	private String memo;

	/**删除标识(0=未删除 1=已删除)*/
	private String deleteTag;

	/**有效性(0=有效 1=无效)*/
	private String timeliness;

	/**创建人ID*/
	private int createId;

	/**创建人名称*/
	private String createName;

	/**创建日期*/
	private Date createDt;

	/**更新人ID*/
	private int updateId;

	/**更新人名称*/
	private String updateName;

	/**更新日期*/
	private Date updateDt;

	/**用户自定义字段1*/
	private String reservedField1;

	/**用户自定义字段2*/
	private String reservedField2;

	/**用户自定义字段3*/
	private String reservedField3;

	/**用户自定义字段4*/
	private String reservedField4;

	/**用户自定义字段5*/
	private String reservedField5;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSmsMsgId() {
		return smsMsgId;
	}

	public void setSmsMsgId(String smsMsgId) {
		this.smsMsgId = smsMsgId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getIsBatch() {
		return isBatch;
	}

	public void setIsBatch(String isBatch) {
		this.isBatch = isBatch;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getGatewayMsgId() {
		return gatewayMsgId;
	}

	public void setGatewayMsgId(String gatewayMsgId) {
		this.gatewayMsgId = gatewayMsgId;
	}

	public int getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(int expiryTime) {
		this.expiryTime = expiryTime;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public Date getDelayedSendDt() {
		return delayedSendDt;
	}

	public void setDelayedSendDt(Date delayedSendDt) {
		this.delayedSendDt = delayedSendDt;
	}

	public Date getExecuteSendDt() {
		return executeSendDt;
	}

	public void setExecuteSendDt(Date executeSendDt) {
		this.executeSendDt = executeSendDt;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDeleteTag() {
		return deleteTag;
	}

	public void setDeleteTag(String deleteTag) {
		this.deleteTag = deleteTag;
	}

	public String getTimeliness() {
		return timeliness;
	}

	public void setTimeliness(String timeliness) {
		this.timeliness = timeliness;
	}

	public int getCreateId() {
		return createId;
	}

	public void setCreateId(int createId) {
		this.createId = createId;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public int getUpdateId() {
		return updateId;
	}

	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getReservedField1() {
		return reservedField1;
	}

	public void setReservedField1(String reservedField1) {
		this.reservedField1 = reservedField1;
	}

	public String getReservedField2() {
		return reservedField2;
	}

	public void setReservedField2(String reservedField2) {
		this.reservedField2 = reservedField2;
	}

	public String getReservedField3() {
		return reservedField3;
	}

	public void setReservedField3(String reservedField3) {
		this.reservedField3 = reservedField3;
	}

	public String getReservedField4() {
		return reservedField4;
	}

	public void setReservedField4(String reservedField4) {
		this.reservedField4 = reservedField4;
	}

	public String getReservedField5() {
		return reservedField5;
	}

	public void setReservedField5(String reservedField5) {
		this.reservedField5 = reservedField5;
	}

}
