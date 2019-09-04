package com.kailash.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kailash.exception.RecordNotFoundException;
import com.kailash.model.User;
import com.kailash.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = userService.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getOneById(@PathVariable int userId) {
		User user = userService.getUserById(userId);
		if (user == null) {
			throw new RecordNotFoundException("Record not found. userId-" + userId);
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@PostMapping
	public ResponseEntity<String> save(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(savedUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();
//		return ResponseEntity.status(HttpStatus.CREATED).body("User is created successfully");
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Object> delete(@PathVariable int userId) {
		User user = userService.getUserById(userId);
		if (user == null) {
			throw new RecordNotFoundException("userId-" + userId);
		}
		userService.delete(user);
		return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
	}

}
