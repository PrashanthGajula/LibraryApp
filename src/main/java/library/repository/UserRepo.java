package library.repository;

import java.util.List;

import library.model.User;

public interface UserRepo {
	User createUser(User user);

	User userLogin(User user);

	List<User> listUsers();
}
