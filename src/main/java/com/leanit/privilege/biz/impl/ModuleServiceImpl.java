package com.leanit.privilege.biz.impl;

import com.leanit.privilege.biz.IModuleService;
import com.leanit.privilege.mapper.ModuleMapper;
import com.leanit.privilege.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements IModuleService {
	
	@Autowired
	private ModuleMapper moduleMapper;
	
	@Override
	public List<Module> getModuleList()
	{
		return moduleMapper.getModuleList();
	}
	
	@Override
	public List<Module> getModuleListByFlag(String flag)
	{
		return moduleMapper.getModuleListByFlag(flag);
	}
	
	@Override
	public List<Module> getModuleListByRoleId(Integer roleId)
	{
		return moduleMapper.getModuleListByRoleId(roleId);
	}
	
	@Override
	public List<Module> getModuleListByUserId(Integer userId)
	{
		return moduleMapper.getModuleListByUserId(userId);
	}
}
