package com.example.altEmployee.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.altEmployee.Resource.EmployeeResource;


public interface EmployeeService {
	
	public EmployeeResource addData(EmployeeResource resource);
	public EmployeeResource getData(long id);
	
	public List<EmployeeResource> getAllempl();
}
