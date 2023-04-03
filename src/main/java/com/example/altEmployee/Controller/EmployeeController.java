package com.example.altEmployee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.altEmployee.Handler.Exception.EmployeeNotFound;
import com.example.altEmployee.Resource.EmployeeResource;
import com.example.altEmployee.Service.EmployeeService;

@RestController
@RequestMapping(value = "/employee", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/addEmployee")
	public ResponseEntity<EmployeeResource> addData(@RequestBody EmployeeResource resource) {
		EmployeeResource data = service.addData(resource);
		return new ResponseEntity<EmployeeResource>(data, HttpStatus.CREATED);
	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Optional<EmployeeResource>> getEmployee(@PathVariable(value = "id") long id) {

		Optional<EmployeeResource> resource = Optional.ofNullable(service.getData(id));

		if (resource.isPresent()) {
			return ResponseEntity.ok(resource);
		}
		throw new EmployeeNotFound("40404", "Requested Employee = " + id + " Not Found");
	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<EmployeeResource>> getAllEmployee() {

		List<EmployeeResource> allempl = service.getAllempl();
		return ResponseEntity.ok(allempl);
	}

}
