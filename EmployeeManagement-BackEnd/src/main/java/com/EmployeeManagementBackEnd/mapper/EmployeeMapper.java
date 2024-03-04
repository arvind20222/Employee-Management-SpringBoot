package com.EmployeeManagementBackEnd.mapper;

import com.EmployeeManagementBackEnd.DTO.EmployeeDto;
import com.EmployeeManagementBackEnd.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
	}
	
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);
	}

}
