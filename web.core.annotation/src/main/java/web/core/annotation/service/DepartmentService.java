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
import web.core.annotation.entity.Department;

@SuppressWarnings("unused")
@Service
@Lazy(true)
public class DepartmentService {
	//UserDAOImpl dao = new UserDAOImpl();
	//UserDAOJdbcImpl dao = new UserDAOJdbcImpl();
	//FileUserDAO dao = new FileUserDAO();
	@Autowired
	@Qualifier("HibernateDAO")
	IDepartmentDAO dao;
	

	public void setDao(IDepartmentDAO dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<Object> getAllDept() throws IOException{
		return dao.listDepartment();
	}
	
	@Transactional
	public Department getDeptById(int deptId) throws SQLException {
		Department emp = dao.getDeptById(deptId);
		return emp;
	}
	
	
	@Transactional
	public Department createDept(int deptId, String deptName, String deptNo, String location) {
		Department emp = dao.createDept(deptId, deptName, deptNo, location);
		return emp;
	}
	
	@Transactional
	public void saveDept(Department emp) {
		dao.saveDept(emp);
	}
	
	@Transactional
	public void updateDept(Department emp) throws IOException {
		dao.updateDept(emp);
	}
	
	@Transactional
	public void saveOrUpdateDept(Department emp) throws IOException {
		dao.saveOrUpdateDept(emp);
	}
	
	@Transactional
	public void deleteDept(Department emp) {
		dao.deleteDept(emp);
	}
	
	@Transactional
	public DepartmentService testInstance() {
		System.out.println("testInstance");
		return new DepartmentService(); 
	}
	
	public DepartmentService() {
		System.out.println("Constructeur par défaut DepartmentService");
	}

//	@Autowired
//	public UserServiceImpl(@Qualifier("JdbcDAO") IUserDAO dao) {
//		super();
//		this.dao = dao;
//		System.out.println("Constructeur simple");
//	}
	
	public DepartmentService(IDepartmentDAO dao) {
		super();
		this.dao = dao;
		System.out.println("Constructeur simple");
	}
	
	public DepartmentService(IDepartmentDAO dao, String nom) {
		super();
		this.dao = dao;
		System.out.println("Constructeur complexe");
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
