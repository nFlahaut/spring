package web.core.annotation.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import web.core.annotation.entity.Employee;

@SuppressWarnings("unused")
@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "empNo", "employee.empNo.empty");
	    ValidationUtils.rejectIfEmpty(err, "job", "employee.job.empty");
	    ValidationUtils.rejectIfEmpty(err, "hireDate", "employee.hireDate.empty");
	    
	    Employee emp = (Employee) obj;
	}
	
	
}
