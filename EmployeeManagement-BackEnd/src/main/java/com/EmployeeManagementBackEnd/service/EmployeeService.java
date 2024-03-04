package com.EmployeeManagementBackEnd.service;

import java.util.List;

import com.EmployeeManagementBackEnd.DTO.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto) ;

	public EmployeeDto getEmployeeByid(Long id);

	public List<EmployeeDto> getAllEmployees();

	EmployeeDto updateEmployeeByid(Long id, EmployeeDto employeeDto);
	
}
