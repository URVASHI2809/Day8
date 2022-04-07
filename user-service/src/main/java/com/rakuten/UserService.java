package com.rakuten;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {
	List<User> users = new ArrayList<>();

	public void save(User user) {
		users.add(user);
		System.out.println("Save method called");
	}

	public List<User> getAllUsers() {
		return users;
	}

	public List<User> getUsersByName(String name) {

		List<User> filteredUsers = users.stream().filter((user) -> user.getName().equals(name))
				.collect(Collectors.toList());
		return filteredUsers;
	}

	public List<User> getUsersByage(int age) {

		List<User> filteredUsers = users.stream().filter((user) -> user.getAge() == age).collect(Collectors.toList());

		return filteredUsers;
	}
}