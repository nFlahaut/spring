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
import web.core.annotation.entity.Role;
import web.core.annotation.entity.User;

@Repository
@Qualifier("HibernateDAO")
@Lazy(true)
@SuppressWarnings({ "unchecked", "unused" })
public class RoleHome implements IRoleDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public RoleHome() {
		super();
		System.out.println("Constructeur par défaut RoleHome");
	}

	public List<Object> listRole() {
		List<Object> listRole = null;
		listRole = sessionFactory.getCurrentSession().createQuery("from Role").list();
		return listRole;
	}

	public Role getRoleById(Integer roleId) {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, roleId);
		return role;
	}
	
	public void saveRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}
	
	public void saveOrUpdateRole(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	public void updateRole(Role role) {
		sessionFactory.getCurrentSession().update(role);
	}

	public void deleteRole(Role role) {
		sessionFactory.getCurrentSession().delete(role);
	}

	public RoleHome testInstance() {
		System.out.println("testInstance");
		return new RoleHome();
	}

	@PreDestroy
		public void testPreDestroy() {
			System.out.println("@PreDestroy Hibernate");
		}

}
