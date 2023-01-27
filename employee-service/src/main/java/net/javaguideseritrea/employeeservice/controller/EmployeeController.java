package net.javaguideseritrea.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.javaguideseritrea.employeeservice.dto.EmployeeDto;
import net.javaguideseritrea.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor //  we want to use constructor based dependency injection, hence we need to create a parameterized constructor for this EmployeeController

@RequestMapping(value="/api/employees")  
public class EmployeeController {

    // So here let me create instance variable private DepartmentService
    private EmployeeService employeeService;

    // build save Employee REST API
    @PostMapping   
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // build get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }



}
