package com.nit.service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nit.model.Employee;
import com.nit.repo.IEmployeeRepo;
@Service
public class ServiceEmployee implements IEmployeeService {

	@Autowired
	IEmployeeRepo repo;

	@Override
	public String saveEmployee(Employee emp) {
		Employee emp1=repo.save(emp);
		if(emp1==null) {
			return "Something went wrong";
		}
		return "Employee saved successfully.";
	}

	@Override
	public String deleteEmpById(Integer id) {
        repo.deleteById(id);
		return "No-"+id+" Employee deleted successfully.";
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee emp=repo.findById(id).get();
		return emp;
	}
    @Override
    public Page<Employee> fetchAllByPages(Pageable pageble) {
    	Page<Employee> page=repo.findAll(pageble);
    	return page;
    }
	@Override
	public Set<String> getAllCountries() {
		Locale[] local=Locale.getAvailableLocales();
	    Set<String> countries=new TreeSet<String>();
	    for(Locale l:local) {
	    	countries.add(l.getDisplayCountry());
	    }
		return countries;
	}
	@Autowired
	private Environment envi;
	@Override
	public List<String> getAllStatesByCountry(String country) {
		String state=envi.getProperty(country);// getting state value from application.properties file using envi object 
		String[] states=state.split(","); // split one value into several states devided with ",".
		List<String> list=Arrays.asList(states); // converting string arrays into List as direct array into set convertion not possible
	 
		return list;
	}
}
