package web.core.annotation.dao;
// Generated 29 mars 2018 10:12:16 by Hibernate Tools 4.3.5.Final

import java.util.List;

import org.springframework.stereotype.Repository;

import web.core.annotation.entity.Department;

@Repository
public interface IDepartmentDAO {

	public List<Object> listDepartment();

	public Department createDept(int deptId, String deptName, String deptNo, String location);

	public Department getDeptById(int deptId);

	public void saveDept(Department dept);
	
	public void updateDept(Department dept);
	
	public void saveOrUpdateDept(Department dept);

	public void deleteDept(Department dept);

}