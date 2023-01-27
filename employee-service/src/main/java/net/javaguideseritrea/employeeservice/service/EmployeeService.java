package net.javaguideseritrea.employeeservice.service;

import net.javaguideseritrea.employeeservice.dto.EmployeeDto;


public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
