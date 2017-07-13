package com.tcw.mapper.erp.login;

import java.util.List;

import com.tcw.modules.login.dto.UserInfoDto;

public interface TCustomerEmployeeMapper {

	List<UserInfoDto> selectList(UserInfoDto userInfoDto);
}
