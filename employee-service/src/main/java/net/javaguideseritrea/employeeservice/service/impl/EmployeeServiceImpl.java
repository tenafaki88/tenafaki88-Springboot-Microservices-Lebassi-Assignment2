package net.javaguideseritrea.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguideseritrea.employeeservice.dto.EmployeeDto;
import net.javaguideseritrea.employeeservice.entity.Employee;
import net.javaguideseritrea.employeeservice.exception.EmployeeEmailAlreadyExistsException;
import net.javaguideseritrea.employeeservice.mapper.EmployeeMapper;
import net.javaguideseritrea.employeeservice.repository.EmployeeRepository;
import net.javaguideseritrea.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        // Convert Employee DTO to Employee JPA entity.
//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );


       // Optional<Employee> optionalEmployee = employeeRepository.save(employeeDto.getEmail());
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmail());

        if(optionalEmployee.isPresent()) {
            System.out.println("Email with " + '"' + employeeDto.getEmail() +'"'  + " already exists for an Employee");
            throw new EmployeeEmailAlreadyExistsException("Email with " +  employeeDto.getEmail() + " already exists for an Employee");
        }

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        // Convert savedEmployee Employee JPA entity to EmployeeDto
//        EmployeeDto savedEmployeeDto = new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail()
//        );


        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);


        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        
        Employee employee = employeeRepository.findById(employeeId).get();
        
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        return employeeDto;
    }
}
