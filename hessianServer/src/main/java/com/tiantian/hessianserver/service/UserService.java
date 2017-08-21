package com.tiantian.hessianserver.service;

import com.tiantian.po.User;

public interface UserService {

	public void addUser(User u);
	
	public void updateUser();
	
	public void delUser();
	
	public String findUser(String username);
	
}
