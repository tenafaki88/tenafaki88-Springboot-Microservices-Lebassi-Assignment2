package net.javaguideseritrea.employeeservice.repository;

import net.javaguideseritrea.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Optional<Department>   
    Optional<Employee> findByEmail(String email);  // A Query Method to retrieve an employee by email.
}
