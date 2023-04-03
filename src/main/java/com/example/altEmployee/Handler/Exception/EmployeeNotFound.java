package com.example.altEmployee.Handler.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMsg;

}
