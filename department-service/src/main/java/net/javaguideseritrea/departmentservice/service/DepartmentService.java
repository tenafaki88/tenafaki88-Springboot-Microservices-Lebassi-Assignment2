package net.javaguideseritrea.departmentservice.service;

import net.javaguideseritrea.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto savedDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
