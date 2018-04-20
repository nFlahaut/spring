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
import web.core.annotation.dao.IRoleDAO;
import web.core.annotation.dao.IUserDAO;
import web.core.annotation.entity.Department;
import web.core.annotation.entity.Role;
import web.core.annotation.entity.User;

@SuppressWarnings("unused")
@Service
@Lazy(true)
public class RoleService {
	//UserDAOImpl dao = new UserDAOImpl();
	//UserDAOJdbcImpl dao = new UserDAOJdbcImpl();
	//FileUserDAO dao = new FileUserDAO();
	@Autowired
	@Qualifier("HibernateDAO")
	IRoleDAO dao;
	

	public void setDao(IRoleDAO dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<Object> getAllRole() throws IOException{
		return dao.listRole();
	}
	
	@Transactional
	public Role getRoleById(Integer roleId) throws SQLException {
		Role role = dao.getRoleById(roleId);
		return role;
	}
	
	@Transactional
	public void saveRole(Role role) {
		dao.saveRole(role);
	}
	
	@Transactional
	public void updateRole(Role role) throws IOException {
		dao.updateRole(role);
	}
	
	@Transactional
	public void saveOrUpdateRole(Role role) throws IOException {
		dao.saveOrUpdateRole(role);
	}
	
	@Transactional
	public void deleteRole(Role role) {
		dao.deleteRole(role);
	}
	
	@Transactional
	public RoleService testInstance() {
		System.out.println("testInstance");
		return new RoleService(); 
	}
	
	public RoleService() {
		System.out.println("Constructeur par défaut RoleService");
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
