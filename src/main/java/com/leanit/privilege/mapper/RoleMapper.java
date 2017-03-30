package com.leanit.privilege.mapper;

import com.leanit.privilege.model.Role;
import com.leanit.privilege.model.RoleSearchModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;


public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    // ������Ϊ�˽�Լ����ʱ�䣬ʹ��MyBatisGenerator���ɵĴ���
    // ��������Բ��㹦�ܣ���ӵĴ���

	/**
	 * ����idɾ����ɫ
	 * @param id
	 * @return
	 */
	Integer deleteRoleById(Integer id);

	/**
	 * ����idɾ����ɫģ�������ϵ
	 * @param roleId
	 * @return
	 */
	Integer deleteRoleModuleById(Integer roleId);

	/**
	 * ����idɾ����ɫ��Դ������ϵ
	 * @param roleId
	 * @return
	 */
	Integer deleteRoleResourceById(Integer roleId);

	/**
	 * ����������ѯ��ɫ�б�����
	 * @param searchModel
	 * @return
	 */
	Integer getRoleTotalBySearch(RoleSearchModel searchModel);

	/**
	 * ����������ѯ�û�List
	 * @param searchModel
	 * @return
	 */
	List<Role> getRoleListBySearch(RoleSearchModel searchModel,RowBounds rowBounds);

	/**
	 * ��ɫ�Ƿ��û�ʹ��
	 * @param roleId
	 * @return
	 */
	Boolean isUsedByUser(Integer roleId);

	/**
	 * �����ɫ����ģ��
	 * @param moduleIds
	 * @param roleId
	 */
	void assignModules(@Param("moduleIds")List<Integer> moduleIds,@Param("roleId")Integer roleId);

	/**
	 * �����ɫ������Դ
	 * @param resourceIds
	 * @param roleId
	 */
	void assignResources(@Param("resourceIds")List<Integer> resourceIds,@Param("roleId")Integer roleId);

	/**
	 * ����userId��ȡ������Ȩ���б�
	 * @param userId
	 * @return
	 */
	List<Role> getRoleListByUserId(@Param("userId")Integer userId);

	/**
	 * ���н�ɫ�б�
	 * @return
	 */
	List<Role> getRoleList();
}
