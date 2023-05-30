package com.nit.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.entity.Student;
import com.nit.model.Employee;
import com.nit.service.ServiceEmployee;
import com.nit.validationEmp.EmployeeValidation;

@Controller
public class MyController  {

	@Autowired
	ServiceEmployee service;
	
	@Autowired
	EmployeeValidation valid;

	@GetMapping("/")
	public String launchIndex() {
		return "index";
	}

	@GetMapping("/regi")
	public String registerEmployee(@ModelAttribute Employee employee) {

		return "register";
	}

	@PostMapping("/result1")
	public String employeeSave(RedirectAttributes redi ,@ModelAttribute Employee employee, Map<String, Object> map,Errors errors) {
		//form valiation
		if(employee.getVflag().equalsIgnoreCase("no")) {
		if(valid.supports(employee.getClass())) {
			valid.validate(employee, errors);
			if(errors.hasErrors()) {
				return "register";
			}
		}}
		
		String msg=service.saveEmployee(employee);
		redi.addFlashAttribute("msg", msg);
		return "redirect:report";
	}

	@GetMapping("/report")
	public String allEmployee(@PageableDefault(page = 0,size = 3,sort = "job",direction = Sort.Direction.ASC) Pageable pageable,Map<String, Object> map) {
		Page<Employee> page=service.fetchAllByPages(pageable);
		map.put("employees", page);
		
		return "employee_report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(RedirectAttributes red,@RequestParam int id,Map<String, Object> map) {
		String msg=service.deleteEmpById(id);
		red.addFlashAttribute("msg", msg)
;		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String editEmployee(@RequestParam int empno,@ModelAttribute Employee employee) {
		Employee emp=service.getEmployeeById(empno);
		BeanUtils.copyProperties(emp,employee);
		
		return "edit_employee";
	}
	@PostMapping("/regi")
	public String saveEditedEmployee(RedirectAttributes red,@ModelAttribute Employee employee,Map<String, Object> map,Errors errors) {
		if(employee.getVflag().equalsIgnoreCase("no")) {
		if(valid.supports(employee.getClass())) {
			valid.validate(employee, errors);
			System.out.println("Ith paryant ala rre ........................................");
			if(errors.hasErrors()) {
				return "edit_employee";
			}}
		}
		String msg=service.saveEmployee(employee);
	    red.addFlashAttribute("msg", msg);
		return "redirect:report";
	}
	// reference data 
	@ModelAttribute("countries")
	public Set<String> allCountries(){
		Set<String> countries=service.getAllCountries();
		return countries;
	}
	@ModelAttribute("state")
	public List<String> allStates(){
		List<String> states=service.getAllStatesByCountry("India");
		return states;
	}
	}