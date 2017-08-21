package com.tiantian.hessianserver.service.impl;

import com.tiantian.hessianserver.service.UserService;
import com.tiantian.po.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	public void addUser(User u) {
		System.out.println(u.getName());
		System.out.println("-------------invoke addUser()---------------");
	}

	public void updateUser() {
		System.out.println("-------------invoke updateUser()---------------");
	}

	public void delUser() {
		System.out.println("-------------invoke delUser()---------------");
	}
	
	public String findUser(String username) {
		System.out.println("-------------invoke findUser---------------");
		return "return:111 " + username;
	}
	

}
