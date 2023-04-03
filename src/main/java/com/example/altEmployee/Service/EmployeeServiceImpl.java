package com.example.altEmployee.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.altEmployee.Resource.EmployeeResource;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private List<EmployeeResource> listEmployee = new ArrayList<EmployeeResource>(
			Arrays.asList(new EmployeeResource(801L, "ompi", "Engineer", 20000L),
					new EmployeeResource(802L, "syed", "Sales", 25000L)));

	@Override
	public EmployeeResource addData(EmployeeResource resource) {

		listEmployee.add(resource);
		return resource;
	}

	@Override
	public EmployeeResource getData(long id) {

		List<EmployeeResource> collect = listEmployee.stream().filter(x -> x.getEmployeeId() == id)
				.collect(Collectors.toList());
		try {
			EmployeeResource resource = collect.get(0);
			return resource;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<EmployeeResource> getAllempl() {
		
		return listEmployee;
	}

}
