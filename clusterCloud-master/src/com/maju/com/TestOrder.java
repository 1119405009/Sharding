package com.maju.com;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maju.common.junit.AbstractSpringJunitTest;
import com.maju.core.bean.User;
import com.maju.core.query.UserQuery;
import com.maju.core.service.UserService;


public class TestOrder extends AbstractSpringJunitTest{

	@Autowired
	private UserService userService;
	
	@Test
	//@Ignore
	public void testGetUser() throws Exception {
		
		UserQuery userQuery = new UserQuery();
		
		userQuery.setUsername("赵六");

		List<User> users = userService.getUserList(userQuery);
		
		for(User u : users){
			
			System.out.println(u);
		}
		
		
	}
	
	
	@Test
//	@Ignore
	public void testAddUser() throws Exception {//0-  333    666  -1024
		User user = new User();
		
		user.setUsername("李四");
		user.setAge(22);
		user.setPhone(1366666);
		user.setEmail("zhaoliu@qq.com");
		
		userService.addUser(user);
	}

}
