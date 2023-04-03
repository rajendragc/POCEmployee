package com.example.altEmployee.Handler.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCode {
	
	private String errorCode;
	private String errorMsg;
	
}
