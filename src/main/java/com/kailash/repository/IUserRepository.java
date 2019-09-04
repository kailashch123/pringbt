package com.kailash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kailash.model.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Integer> {

	/*
	 * @Query("selct * from user where fname=? and lastname=?") User
	 * getByfname(String fname, String lname);
	 */
}
