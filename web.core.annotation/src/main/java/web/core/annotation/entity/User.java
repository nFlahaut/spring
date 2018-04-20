package web.core.annotation.entity;
// default package
// Generated 20 avr. 2018 10:34:44 by Hibernate Tools 4.0.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Proxy;

/**
 * User generated by hbm2java
 */
@Entity
@Proxy(lazy=false)
@Table(name = "user", catalog = "exemple_etat_objet", uniqueConstraints = @UniqueConstraint(columnNames = "Username"))
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private Role role;
	private String username;
	private String password;

	public User() {
	}

	public User(Role role, String username, String password) {
		this.role = role;
		this.username = username;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "User_ID", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Role_ID", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "Username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}