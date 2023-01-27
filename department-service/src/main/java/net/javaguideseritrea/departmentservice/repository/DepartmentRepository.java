package net.javaguideseritrea.departmentservice.repository;

import net.javaguideseritrea.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Optional<Department>
    Optional<Department> findByDepartmentCode(String departmentCode);  // A Query Method to retrieve a user by DepartmentCode.
}
