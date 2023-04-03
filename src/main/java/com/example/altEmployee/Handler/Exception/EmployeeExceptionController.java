package com.example.altEmployee.Handler.Exception;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class EmployeeExceptionController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value=EmployeeNotFound.class)
	public ResponseEntity<Object> exception(EmployeeNotFound emplexcep){
		
		ErrorCode code = new ErrorCode(emplexcep.getErrorCode(),emplexcep.getErrorMsg());
		return new ResponseEntity<>(code,HttpStatus.NOT_FOUND);
		
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ErrorCode> listErr = new LinkedList<>(); 
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		
			for (ObjectError objectError : allErrors) {
//				Map<String, String> errors = new HashMap<>();
//				errors.put("errCode", "40400");
//				errors.put("errMsg", objectError.getDefaultMessage());
				ErrorCode errMsg =new ErrorCode(objectError.getDefaultMessage(),"40400");
				listErr.add(errMsg);
			}
		return new ResponseEntity<Object>(listErr, HttpStatus.BAD_REQUEST);
	}

}
