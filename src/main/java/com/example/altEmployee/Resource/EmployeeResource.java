package com.example.altEmployee.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResource {
	
	private Long employeeId;
	
	private String employeeName;
	
	private String roll;
	
	private Long salary;
}
