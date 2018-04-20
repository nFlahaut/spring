package web.core.annotation.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import web.core.annotation.entity.Department;
import web.core.annotation.entity.Employee;

@SuppressWarnings("unused")
@Component
public class DepartmentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Department.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "deptId", "department.deptId.empty");
	    ValidationUtils.rejectIfEmpty(err, "deptNo", "department.deptNo.empty");
	    ValidationUtils.rejectIfEmpty(err, "deptName", "department.deptName.empty");
	    ValidationUtils.rejectIfEmpty(err, "location", "department.location.empty");
	    
	    Department dept = (Department) obj;
	}
	
	
}
