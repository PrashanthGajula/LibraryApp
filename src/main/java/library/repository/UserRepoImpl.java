package library.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import library.model.User;

@Repository("userRepo")
public class UserRepoImpl implements UserRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User createUser(User user) {
		
		String sql = "insert into lib_users(userName, password, fName, lName, age, admin) values(?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getPassword(), user.getfName(),
	    user.getlName(), user.getAge(), user.getAdmin()});
		User newUser = validateUser(user.getUserName(), user.getPassword());
		return newUser;
	}
	
	public User validateUser(String userName, String password) {
		String sql = "select * from lib_users where userName='" + userName + "' and password='" + password + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}
	

	  class UserMapper implements RowMapper<User> {
	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
	    user.setUid(rs.getInt("uid"));
	    user.setUserName(rs.getString("userName"));
	    user.setPassword(rs.getString("password"));
	    user.setfName(rs.getString("fName"));
	    user.setlName(rs.getString("lName"));
	    user.setAge(rs.getInt("age"));
	    user.setAdmin(rs.getString("admin"));
	    return user;
	  }
	}

	@Override
	public User userLogin(User user) {
		return validateUser(user.getUserName(), user.getPassword());
	}

	@Override
	public List<User> listUsers() {
		String sql = "select * from lib_users";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}
}
