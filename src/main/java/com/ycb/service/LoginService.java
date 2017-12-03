package com.ycb.service;

import com.ycb.domin.User;

public interface LoginService {
	public User login(String userName, String passWord);

	public int registration(String phone, String password, String name);
}
