package com.leanit.privilege.mapper;

import com.leanit.privilege.model.User;
import com.leanit.privilege.model.UserSearchModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    // ������Ϊ�˽�Լ����ʱ�䣬ʹ��MyBatisGenerator���ɵĴ���
    // ��������Բ��㹦�ܣ���ӵĴ���

	/**
	 * �����û�����ѯ�û�
	 * @param username
	 * @return
	 */
	User getUserByUsername(@Param("username") String username);

	/**
	 * ����������ѯ�û�����
	 * @param searchModel
	 * @return
	 */
	Integer getUserTotalBySearch(UserSearchModel searchModel);

	/**
	 * ����������ѯ�û�List
	 * @param searchModel
	 * @return
	 */
	List<User> getUserListBySearch(UserSearchModel searchModel, RowBounds rowBounds);

	/**
	 * ����idɾ���û������Ľ�ɫ
	 * @param id
	 * @return
	 */
	Integer deleteUserRoleById(Integer id);

	/**
	 * ���û������ɫ
	 * @param roleIds
	 * @param userId
	 */
	void assignRoles(@Param("roleIds") List<Integer> roleIds, @Param("userId") Integer userId);
}
