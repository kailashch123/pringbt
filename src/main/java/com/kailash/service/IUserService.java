package com.kailash.service;

import java.util.List;

import com.kailash.model.User;

public interface IUserService {

	User getUserById(int userId);
	List<User> getAllUser();
	User save(User user);
	void delete(User user);

}
