package com.rakuten;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service;

	@PostMapping
	String saveUser(@RequestBody User user) {
		System.out.println(user.getName());
		System.out.println(user.getAge());

		service.save(user);
		return "Saved successfully";
	}

	@GetMapping
	List<User> getUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/name/{name}")
	List<User> getUsersByName(@PathVariable String name) {
		System.out.println(name);
		if (name.isEmpty() || name.isBlank()) {
			throw new IllegalArgumentException("Name Cannot be Empty!!" + name);
		}

		return service.getUsersByName(name);
	}

	@GetMapping("/age/{age}") // localhost:8081/user/age/21
	List<User> getUsersByage(@PathVariable int age) {
		if (age <= 0) {
			throw new IllegalArgumentException("Age cannot be negative= " + age);
		}
		System.out.println(age);
		return null;

	}

}
