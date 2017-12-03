package com.ycb.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycb.domin.User;
import com.ycb.model.ResponseBean;
import com.ycb.service.LoginService;

/**
 * 
 * @author chenghui
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private  LoginService  loginService;
	
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ResponseBean login(String username, String password) {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return new ResponseBean("false", "用户名或者密码不能为空!");
		}
	    User user=loginService.login(username, password);
	    if(user == null){
	    	return new ResponseBean("false", "用户名和密码错误!");
	    }
	    return new ResponseBean("true", "登录成功!");
	}
	
	/**
	 * 注册
	 * @param phone
	 * @param password
	 * @param name
	 * @return
	 */
	@RequestMapping("/registration")
	public String  registration(String phone,String password,String name){
		if(loginService.registration(phone,password,name) !=0){
			return "注册成功！";
		}
		return "系统异常!";
	}
}
