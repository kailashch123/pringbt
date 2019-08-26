package com.kailash.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.model.User;
import com.kailash.repository.IUserRepository;

@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public User getUserById(int userId) {
		Optional<User> optional = userRepository.findById(userId);
		User user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		User savedUser = userRepository.save(user);;
		return savedUser;
		
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

}
