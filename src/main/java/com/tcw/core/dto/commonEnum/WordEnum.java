package com.tcw.core.dto.commonEnum;

public enum WordEnum {
	
	WORD_TYPE_WT00("WT00", "系统维护"),
	WORD_TYPE_WT01("WT01", "助通维护"),
	WORD_TYPE_WT02("WT02", "梦网维护"),
	WORD_TYPE_WT03("WT03", "国都维护");

	private String message;
    private String code;

    WordEnum(String code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
