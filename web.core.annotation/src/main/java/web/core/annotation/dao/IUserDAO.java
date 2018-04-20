package web.core.annotation.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import web.core.annotation.entity.User;

@Repository
public interface IUserDAO {

	public List<Object> listUser();
	
	public User getUserById(int id) throws SQLException;
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public void saveOrUpdateUser(User user);
}
	

