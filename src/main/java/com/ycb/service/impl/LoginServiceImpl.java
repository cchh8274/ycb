package com.ycb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycb.dao.UserMapper;
import com.ycb.domin.User;
import com.ycb.service.LoginService;
@Service
public class LoginServiceImpl  implements LoginService{
		@Autowired
		private UserMapper userMapper;
		
		/**
		 * 登录
		 */
		public  User  login(String userName,String passWord){
			return this.userMapper.login(userName,passWord);
		}
		/**
		 * 注册
		 */
		public int registration(String phone, String password, String name) {
			User user=new User();
			user.setPhone(phone);
			user.setPassword(password);
			user.setName(name);
			return userMapper.insert(user);
		}
}
