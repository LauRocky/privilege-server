package com.leanit.privilege.biz;

import com.leanit.privilege.model.User;

public interface IPrivilegeBaseApiService {

	User getUserByUsername(String username);
	
	String getModuleTree(Integer userId, String visitedModule, String visitedResource);
	
	Integer updateUserById(User user);
}
