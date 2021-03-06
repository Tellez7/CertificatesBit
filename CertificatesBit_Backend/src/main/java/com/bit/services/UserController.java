package com.bit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bit.entities.User;
import com.bit.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepositoryDAO;

	@RequestMapping("/createUser")
	public User save(@RequestParam long id, @RequestParam String user, @RequestParam String password,
			@RequestParam boolean admin) {
		User newUser = new User();
		newUser.setId(id);
		newUser.setUser(user);
		newUser.setPassword(password);
		newUser.setAdmin(admin);
		return userRepositoryDAO.save(newUser);
	}

	@RequestMapping("/updateUser")
	public User updateUser(@RequestParam long id, @RequestParam String user, @RequestParam String password,
			@RequestParam boolean admin) {
		User userUpdate = userRepositoryDAO.findById(id);
		userUpdate.setUser(user);
		userUpdate.setPassword(password);
		userUpdate.setAdmin(admin);
		return userRepositoryDAO.save(userUpdate);
	}

	@RequestMapping("/getAllUsers")
	public List<User> findAll() {
		return userRepositoryDAO.findAll();
	}

	@RequestMapping("/deleteUserById")
	public void deleteById(@RequestParam long id) {
		userRepositoryDAO.deleteById(id);
	}

	@RequestMapping("/getUserById")
	public User findById(@RequestParam long id) {
		return userRepositoryDAO.findById(id);
	}

	@RequestMapping("/userExistsById")
	public boolean existsById(@RequestParam Long id) {
		if (userRepositoryDAO.existsById(id)) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping("/userExistsByData")
	public User existsByData(@RequestParam String userEntry, @RequestParam String password) {
		User userReturn = null;
		for (User user : userRepositoryDAO.findAll()) {
			if (user.getUser().equals(userEntry) && user.getPassword().equals(password)) {
				userReturn = user;
			}
		}
		return userReturn;
	}
}
