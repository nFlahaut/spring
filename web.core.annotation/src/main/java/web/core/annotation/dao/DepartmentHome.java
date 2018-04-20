package web.core.annotation.dao;
// Generated 29 mars 2018 10:12:16 by Hibernate Tools 4.3.5.Final

import java.sql.Date;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import web.core.annotation.entity.Department;



@Repository
@Qualifier("HibernateDAO")
@Lazy(true)
@SuppressWarnings({ "unchecked", "unused" })
public class DepartmentHome implements IDepartmentDAO {
	@Autowired
	SessionFactory sessionFactory;

	public DepartmentHome() {
		super();
		System.out.println("Constructeur par défaut DepartmentHome");
	}

	public List<Object> listDepartment() {
		List<Object> courses = null;
		courses = sessionFactory.getCurrentSession().createQuery("from Department").list();
		return courses;
	}

	public Department createDept(int deptId, String deptName, String deptNo, String location) {
		Department dept = new Department();
		dept.setDeptId(deptId);
		dept.setDeptName(deptName);
		dept.setDeptNo(deptNo);
		dept.setLocation(location);
		sessionFactory.getCurrentSession().save(dept);
		return dept;
	}

	public Department getDeptById(int deptId) {
		Session session = sessionFactory.getCurrentSession();
		Department dept = (Department) session.get(Department.class, deptId);
		return dept;
	}

	public void saveDept(Department dept) {
		sessionFactory.getCurrentSession().save(dept);
	}

	public void updateDept(Department dept) {
		sessionFactory.getCurrentSession().update(dept);
	}
	
	public void saveOrUpdateDept(Department dept) {
		sessionFactory.getCurrentSession().saveOrUpdate(dept);
	}

	public void deleteDept(Department dept) {
		sessionFactory.getCurrentSession().delete(dept);
	}

	public DepartmentHome testInstance() {
		System.out.println("testInstance");
		return new DepartmentHome();
	}

	@PreDestroy
		public void testPreDestroy() {
			System.out.println("@PreDestroy Hibernate");
		}

}