package com.EmployeeManagementBackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementBackEnd.DTO.EmployeeDto;
import com.EmployeeManagementBackEnd.Exception.ResourceNotFoundException;
import com.EmployeeManagementBackEnd.entity.Employee;
import com.EmployeeManagementBackEnd.mapper.EmployeeMapper;
import com.EmployeeManagementBackEnd.repository.EmployeeRepository;
@Service
public class EmployeeServiceImplementation implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {	
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		return EmployeeMapper.mapToDto(savedEmployee);
	}
	@Override
	public EmployeeDto getEmployeeByid(Long id) {
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee is not Found"+id));
		return EmployeeMapper.mapToDto(employee);
	}
	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> emp=employeeRepository.findAll();
		return emp.stream().map(e->EmployeeMapper.mapToDto(e)).toList();
	}
	@Override
	public EmployeeDto updateEmployeeByid(Long id, EmployeeDto employeeDto) {
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee is not Found"+id));
		employee.setId(id);
		employee.setFirstName(employeeDto.getFirstName());
		employee.setEmail(employeeDto.getEmail());
		employee.setLastName(employeeDto.getLastName());
		Employee updatedEmployee=employeeRepository.save(employee);
		return EmployeeMapper.mapToDto(updatedEmployee);
	}

}
