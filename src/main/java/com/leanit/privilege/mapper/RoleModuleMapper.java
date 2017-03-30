package com.leanit.privilege.mapper;

import com.leanit.privilege.model.RoleModule;

public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);
}
