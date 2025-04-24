package com.airline.services;

import java.util.Optional;
import com.airline.entiry.User;
import com.airline.exception.ResourceAlreadyExistException;
import example.airline.dao.UserDao;

public class UserServices {

	UserDao dao = null;

	public UserServices() {
		dao = new UserDao();
	}

	public void registerUser(String name, String email, String password) {
		Optional<User> foundUser = dao.findAll().stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
		if (foundUser.isPresent()) {
			throw new ResourceAlreadyExistException("This email is already registered.");
		}
		dao.save(new User(0, name, email, password));

	}

	public User login(String email, String password) {
		return dao.searchUserByEmailAndPassword(email, password);
	}
}
