package com.leanit.privilege.mapper;

import com.leanit.privilege.model.RoleResource;

public interface RoleResourceMapper {
    int insert(RoleResource record);

    int insertSelective(RoleResource record);
}
