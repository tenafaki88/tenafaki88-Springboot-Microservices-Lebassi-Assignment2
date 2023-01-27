package net.javaguideseritrea.departmentservice.mapper;

import net.javaguideseritrea.departmentservice.dto.DepartmentDto;
import net.javaguideseritrea.departmentservice.entity.Department;

public class DepartmentMapper {

    // Convert Department JPA Entity into DepartmentDto
    public static DepartmentDto mapToDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }

    // Convert DepartmentDto into Department JPA Entity
    public static Department mapToDepartment(DepartmentDto departmentDto) {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }

}
