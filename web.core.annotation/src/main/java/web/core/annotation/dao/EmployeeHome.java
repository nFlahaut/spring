package web.core.annotation.dao;
// Generated 29 mars 2018 10:12:16 by Hibernate Tools 4.3.5.Final

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.core.annotation.entity.Employee;

@Repository
@Qualifier("HibernateDAO")
@Lazy(true)
@SuppressWarnings({ "unchecked", "unused" })
public class EmployeeHome implements IEmployeeDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public EmployeeHome() {
		super();
		System.out.println("Constructeur par défaut EmployeeHome");
	}

	public List<Object> listEmployee() {
		List<Object> listEmployee = null;
		listEmployee = sessionFactory.getCurrentSession().createQuery("from Employee").list();
		return listEmployee;
	}


	public Employee createEmp(String empNo, Date hireDate, String job) {
		Employee emp = new Employee();
		emp.setEmpNo(empNo);
		emp.setHireDate(hireDate);
		emp.setJob(job);
		sessionFactory.getCurrentSession().save(emp);
		return emp;
	}

	public Employee getById(Long empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		return emp;
	}
	
	public void saveEmp(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}
	
	public void saveOrUpdateEmp(Employee emp) {
		sessionFactory.getCurrentSession().saveOrUpdate(emp);
	}

	public void updateEmp(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);
	}

	public void deleteEmp(Employee emp) {
		sessionFactory.getCurrentSession().delete(emp);
	}

	public EmployeeHome testInstance() {
		System.out.println("testInstance");
		return new EmployeeHome();
	}

	@PreDestroy
		public void testPreDestroy() {
			System.out.println("@PreDestroy Hibernate");
		}



}