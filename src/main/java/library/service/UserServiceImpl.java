package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.model.User;
import library.repository.UserRepo;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.createUser(user);
	}

	@Override
	public User userLogin(User user) {
		return userRepo.userLogin(user);
	}

	@Override
	public List<User> listUsers() {
		return userRepo.listUsers();
	}
}
