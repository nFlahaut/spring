package web.core.annotation.dao;
// Generated 29 mars 2018 10:12:16 by Hibernate Tools 4.3.5.Final

import java.util.List;

import org.springframework.stereotype.Repository;

import web.core.annotation.entity.Role;

@Repository
public interface IRoleDAO {

	public List<Object> listRole();

	public Role getRoleById(Integer roleId);
	
	public void saveRole(Role role);
	
	public void saveOrUpdateRole(Role role);

	public void updateRole(Role role);

	public void deleteRole(Role role);


}
