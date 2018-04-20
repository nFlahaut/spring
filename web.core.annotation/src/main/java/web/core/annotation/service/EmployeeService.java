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

import web.core.annotation.dao.IEmployeeDAO;
import web.core.annotation.entity.Employee;



@SuppressWarnings("unused")
@Service
@Lazy(true)
public class EmployeeService {
	//UserDAOImpl dao = new UserDAOImpl();
	//UserDAOJdbcImpl dao = new UserDAOJdbcImpl();
	//FileUserDAO dao = new FileUserDAO();
	@Autowired
	@Qualifier("HibernateDAO")
	IEmployeeDAO dao;
	

	public void setDao(IEmployeeDAO dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<Object> getAllEmp() throws IOException{
		return dao.listEmployee();
	}
	
	@Transactional
	public Employee getById(Long empId) throws SQLException {
		Employee emp = dao.getById(empId);
		return emp;
	}
	
	
	@Transactional
	public Employee createEmp(String empNo, Date hireDate, String job) {
		Employee emp = dao.createEmp(empNo, hireDate, job);
		return emp;
	}
	
	@Transactional
	public void saveEmp(Employee emp) {
		dao.saveEmp(emp);
	}
	
	@Transactional
	public void updateEmp(Employee emp) throws IOException {
		dao.updateEmp(emp);
	}
	
	@Transactional
	public void saveOrUpdateEmp(Employee emp) {
		dao.saveOrUpdateEmp(emp);
	}
	
	@Transactional
	public void deleteEmp(Employee emp) {
		dao.deleteEmp(emp);
	}
	
	@Transactional
	public EmployeeService testInstance() {
		System.out.println("testInstance");
		return new EmployeeService(); 
	}
	
	public EmployeeService() {
		System.out.println("Constructeur par défaut EmployeeService");
	}

//	@Autowired
//	public UserServiceImpl(@Qualifier("JdbcDAO") IUserDAO dao) {
//		super();
//		this.dao = dao;
//		System.out.println("Constructeur simple");
//	}
	
	public EmployeeService(IEmployeeDAO dao) {
		super();
		this.dao = dao;
		System.out.println("Constructeur simple");
	}
	
	public EmployeeService(IEmployeeDAO dao, String nom) {
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
