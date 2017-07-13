package com.tcw.core.dto.commonEnum;

public enum RtnEnum {
	
	/**成功(000000)*/
	SUCCESS("000000", "成功"),
	
	/**参数为空(100000)*/
	PARAMETER_NULL("100000", "参数为空"), 
	
	/**参数有无(100001)*/
	PARAMETER_ERROR("100001", "参数有错"),
	
	/**系统报错(200000)*/
	SYSTEM_FAIL("200000", "系统报错"),
	
	/**数据已存在(300000)*/
	DATA_EXIST("300000", "数据已存在"),
	
	/**数据为空(300001)*/
	DATE_NULL("300001", "数据为空"),
	
	/**连接超时(400000)*/
	SESSION_TIMEOUT("400000", "连接超时"),
	
	/**用户名为空(100001)*/
	LOGIN_ID_NULL("100001", "用户名为空"),
	
	/**用户不存在(100002)*/
	LOGIN_ID_NO_EXIST("100002", "用户不存在"),
	
	/**用户密码为空(100003)*/
	LOGIN_PW_NULL("100003", "用户密码为空"),
	
	/**用户密码错误(100004)*/
	LOGIN_PW_ERROR("100004", "用户密码错误"),
	
	/**没有平台权限(100005)*/
	LOGIN_BIZ_CODE_ERROR("100005", "没有平台权限");
	
	private String message;
    private String code;

    RtnEnum(String code, String message) {
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
