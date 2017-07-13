package com.tcw.modules.system.dto;

import java.util.Date;

public class BlackListDto {

	/**ID主键*/
	private int id = -1;

	/**手机号*/
	private String phone;

	/**备注*/
	private String memo;

	/**删除标识(0=未删除 1=已删除)*/
	private String deleteTag;

	/**有效性(0=有效 1=无效)*/
	private String timeliness;

	/**创建人ID*/
	private int createId;

	/**创建日期*/
	private Date createDt;

	/**更新人ID*/
	private int updateId;

	/**更新日期*/
	private Date updateDt;

	/**用户自定义字段1*/
	private String reservedField1;

	/**用户自定义字段2*/
	private String reservedField2;

	private int page;
	private int rows;
	private int total;

	private String createUserName;
	private String searchItem;
	private String createDtStr;
	private String updateDtStr;
	
	private String[] idArray;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getSearchItem() {
		return searchItem;
	}

	public void setSearchItem(String searchItem) {
		this.searchItem = searchItem;
	}

	public String getCreateDtStr() {
		return createDtStr;
	}

	public void setCreateDtStr(String createDtStr) {
		this.createDtStr = createDtStr;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public String[] getIdArray() {
		return idArray;
	}

	public void setIdArray(String[] idArray) {
		this.idArray = idArray;
	}
	
}
