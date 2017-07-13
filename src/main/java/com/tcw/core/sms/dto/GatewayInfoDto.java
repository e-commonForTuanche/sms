package com.tcw.core.sms.dto;

public class GatewayInfoDto {

	/**ID主键*/
	private int id;

	/**网关名称*/
	private String gatewayName;

	/**父级网关ID(因为有可能会有子帐号)*/
	private int parentGatewayId;

	/**短信平台中类名*/
	private String className;
	
	/**网关ID*/
	private int gatewayId;

	/**通讯类型(LT00=上行, LT01=下行)*/
	private String linkType;

	/**是否为批量(Y=是 N=否)*/
	private String isBatch;

	/**HTTP方式接口路径*/
	private String httpUrl;

	/**HTTP方式参数JSON串*/
	private String httpParamJson;

	/**备注*/
	private String memo;

	/**删除标识(0=未删除 1=已删除)*/
	private String deleteTag;

	/**有效性(0=有效 1=无效)*/
	private String timeliness;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public int getParentGatewayId() {
		return parentGatewayId;
	}

	public void setParentGatewayId(int parentGatewayId) {
		this.parentGatewayId = parentGatewayId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(int gatewayId) {
		this.gatewayId = gatewayId;
	}

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public String getIsBatch() {
		return isBatch;
	}

	public void setIsBatch(String isBatch) {
		this.isBatch = isBatch;
	}

	public String getHttpUrl() {
		return httpUrl;
	}

	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}

	public String getHttpParamJson() {
		return httpParamJson;
	}

	public void setHttpParamJson(String httpParamJson) {
		this.httpParamJson = httpParamJson;
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

}
