package com.leanit.privilege.mapper;

import com.leanit.privilege.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    // ������Ϊ�˽�Լ����ʱ�䣬ʹ��MyBatisGenerator���ɵĴ���
    // ��������Բ��㹦�ܣ���ӵĴ���

	/**
	 * ��ѯ����Department����
	 * @return
	 */
	List<Department> getDepartmentList();
	/**
	 * ��ѯ����Department����
	 * @return
	 */
	List<Department> getDepartmentListByParentId(@Param("parentId") Integer parentId);
	/**
	 * �����Ƿ��û�ʹ��
	 * @param departmentId
	 */
	Boolean isUsedByUser(Integer departmentId);
}
