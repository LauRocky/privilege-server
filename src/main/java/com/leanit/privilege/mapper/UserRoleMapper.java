package com.leanit.privilege.mapper;

import com.leanit.privilege.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}
