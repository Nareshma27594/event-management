package com.cybage.services;

import com.cybage.bean.User;

public interface UserService {
	public User getUserById(int id);
	public boolean addUser(User user);
}
