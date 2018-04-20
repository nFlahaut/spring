package web.core.annotation.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import web.core.annotation.entity.Employee;


@Repository
public interface IEmployeeDAO {
	
	public List<Object> listEmployee();
	
	public Employee createEmp(String empNo, Date hireDate, String job);
	
	public Employee getById(Long empId) throws SQLException;
	
	public void saveEmp(Employee emp);
	
	public void updateEmp(Employee emp);
	
	public void deleteEmp(Employee emp);
	
	public void saveOrUpdateEmp(Employee emp);
}
