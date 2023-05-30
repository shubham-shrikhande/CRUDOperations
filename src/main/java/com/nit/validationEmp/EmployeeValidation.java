package com.nit.validationEmp;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nit.model.Employee;
@Component
public class EmployeeValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Employee emp=(Employee)target;
		if(emp.getEname()==null || emp.getEname().length()==0 || emp.getEname().equals("")) {
			errors.rejectValue("ename", "empname.required");
		}
		else if(emp.getEname().length()>10){
			errors.rejectValue("ename", "empname.maxlength");
		}
		
		
		if(emp.getJob()==null || emp.getJob().length()==0 || emp.getJob().equals("")) {
			errors.rejectValue("job", "empjob.required");
		}
		else if(emp.getJob().length()>10){
			errors.rejectValue("job", "empjob.maxlength");
		}
		
		
		if(emp.getSal()==null) {
			errors.rejectValue("sal", "empsal.required");
		}
		else if(emp.getSal()<1 || emp.getSal()>100000){
			errors.rejectValue("sal", "empsal.range");
		}
	}

}
