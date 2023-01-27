package net.javaguideseritrea.employeeservice.mapper;

import net.javaguideseritrea.employeeservice.dto.EmployeeDto;
import net.javaguideseritrea.employeeservice.entity.Employee;

public class EmployeeMapper {

    // Convert Employee JPA Entity into EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto =  new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
        return employeeDto;
    }

    // Convert EmployeeDto into Employee JPA Entity
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee =  new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
        return employee;
    }

}
