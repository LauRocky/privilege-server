package com.leanit.privilege.mapper;

import com.leanit.privilege.model.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
    
    // ������Ϊ�˽�Լ����ʱ�䣬ʹ��MyBatisGenerator���ɵĴ���
    // ��������Բ��㹦�ܣ���ӵĴ���

	/**
	 * ��ȡ����Module
	 * @return
	 */
	List<Module> getModuleList();

	/**
	 * ����flag��ȡModule
	 * @param flag
	 * @return
	 */
	List<Module> getModuleListByFlag(@Param("flag") String flag);

	/**
	 * ��ѯroleId����Ȩ�޵�ģ���б�
	 * @param roleId
	 * @return
	 */
	List<Module> getModuleListByRoleId(Integer roleId);

	/**
	 * ��ѯuserId����Ȩ�޵�ģ���б�
	 * @param userId
	 * @return
	 */
	List<Module> getModuleListByUserId(Integer userId);	
}
