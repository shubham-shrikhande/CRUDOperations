package com.nit.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nit.model.Employee;

public interface IEmployeeService {

	public String saveEmployee(Employee emp);
	public String deleteEmpById(Integer id);
	public Employee getEmployeeById(int id);
    public Page<Employee> fetchAllByPages(Pageable pageble);
    
    //reference data 
    public Set<String> getAllCountries();
    public List<String> getAllStatesByCountry(String country);
}
