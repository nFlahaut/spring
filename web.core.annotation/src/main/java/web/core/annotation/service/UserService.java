package web.core.annotation.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.core.annotation.dao.IDepartmentDAO;
import web.core.annotation.dao.IUserDAO;
import web.core.annotation.entity.Department;
import web.core.annotation.entity.User;

@SuppressWarnings("unused")
@Service
@Lazy(true)
public class UserService {
	//UserDAOImpl dao = new UserDAOImpl();
	//UserDAOJdbcImpl dao = new UserDAOJdbcImpl();
	//FileUserDAO dao = new FileUserDAO();
	@Autowired
	@Qualifier("HibernateDAO")
	IUserDAO dao;
	

	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<Object> getAllUser() throws IOException{
		return dao.listUser();
	}
	
	@Transactional
	public User getUserById(Integer userId) throws SQLException {
		User user = dao.getUserById(userId);
		return user;
	}
	
	@Transactional
	public void saveUser(User user) {
		dao.saveUser(user);
	}
	
	@Transactional
	public void updateUser(User user) throws IOException {
		dao.updateUser(user);
	}
	
	@Transactional
	public void saveOrUpdateUser(User user) throws IOException {
		dao.saveOrUpdateUser(user);
	}
	
	@Transactional
	public void deleteUser(User user) {
		dao.deleteUser(user);
	}
	
	@Transactional
	public UserService testInstance() {
		System.out.println("testInstance");
		return new UserService(); 
	}
	
	public UserService() {
		System.out.println("Constructeur par défaut UserService");
	}
	

	@PostConstruct
	public void testPostConstruct() {
		System.out.println("@PostConstruct");
	}
	
	@PreDestroy
	public void testPreDestroy() {
		System.out.println("@PreDestroy Service");
	}
	
	
	
	

}
