package com.leanit.privilege.mapper;

import com.leanit.privilege.model.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    // ������Ϊ�˽�Լ����ʱ�䣬ʹ��MyBatisGenerator���ɵĴ���
    // ��������Բ��㹦�ܣ���ӵĴ���

	/**
	 * ��ȡ����resource
	 * @return
	 */
	List<Resource> getResourceList();

	/**
	 * ��������ģ���ȡ��Դ
	 * @return
	 */
	List<Resource> getResourceListByModuleFlag(@Param("moduleFlags") List<String> moduleFlags, @Param("userId") Integer userId);

	/**
	 * ������Դid�ж��Ƿ񱻽�ɫʹ��
	 * @param resourceId
	 * @return
	 */
	Boolean isUsedByRole(@Param("resourceId") Integer resourceId);

	/**
	 * ������ɫ����Ȩ�޵���Դ�б�
	 * @param roleId
	 * @return
	 */
	List<Resource> getResourceListByRoleId(Integer roleId);

	/**
	 * ����parentId��ȡ��Դ
	 * @param parentId
	 * @return
	 */
	List<Resource> getResourceListByParentId(@Param("parentId") Integer parentId);
}
