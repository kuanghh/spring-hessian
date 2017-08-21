package com.tiantian.hessianclient.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiantian.hessianserver.service.UserService;
import com.tiantian.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class HessianTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		User u = new User();
		u.setName("ontheroad");
		u.setAge(20);
		userService.addUser(u);
		userService.updateUser();
		userService.delUser();
		String user = userService.findUser("ZhangSan");
		System.out.println(user);
		System.out.println("---------------------------------finished----------------------------------");
	}
	
}
