package web.core.annotation.convert;


import java.sql.SQLException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import web.core.annotation.entity.Department;
import web.core.annotation.service.DepartmentService;

@Component
public class DepartmentConverter implements  	Converter<String , Department> {
    
	
    private DepartmentService serviceDept;

    public DepartmentConverter(DepartmentService serviceDept) {
		this.serviceDept = serviceDept;
	}
	
	
	public DepartmentConverter() {
	}

	public Department convert(String id) {
		Integer deptId = Integer.parseInt(id);
		Department dept = null;
		try {
			dept = serviceDept.getDeptById(deptId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
	}



//	@Override
//    public void setAsText(String id) 
//    {
//		 Department department = null;
//		 department = departmentDao.findDepartment(id);
//		 this.setValue(department);
//    }
}