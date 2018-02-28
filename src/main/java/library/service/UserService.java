package library.service;

import java.util.List;

import library.model.User;

public interface UserService {
	User createUser(User user);

	User userLogin(User user);
	
	List<User> listUsers();
}
