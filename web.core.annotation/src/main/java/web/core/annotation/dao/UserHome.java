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
import web.core.annotation.entity.User;

@Repository
@Qualifier("HibernateDAO")
@Lazy(true)
@SuppressWarnings({ "unchecked", "unused" })
public class UserHome implements IUserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public UserHome() {
		super();
		System.out.println("Constructeur par défaut UserHome");
	}

	public List<Object> listUser() {
		List<Object> listUser = null;
		listUser = sessionFactory.getCurrentSession().createQuery("from User").list();
		return listUser;
	}

	public User getUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}
	
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	public void saveOrUpdateUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public UserHome testInstance() {
		System.out.println("testInstance");
		return new UserHome();
	}

	@PreDestroy
		public void testPreDestroy() {
			System.out.println("@PreDestroy Hibernate");
		}

}
