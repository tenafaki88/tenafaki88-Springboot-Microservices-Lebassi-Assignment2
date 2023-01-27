package net.javaguideseritrea.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguideseritrea.departmentservice.dto.DepartmentDto;
import net.javaguideseritrea.departmentservice.entity.Department;
import net.javaguideseritrea.departmentservice.exception.DepartmentCodeAlreadyExistsException;
import net.javaguideseritrea.departmentservice.mapper.DepartmentMapper;
import net.javaguideseritrea.departmentservice.repository.DepartmentRepository;
import net.javaguideseritrea.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto savedDepartment(DepartmentDto departmentDto) {

        // Convert department DTO to Department JPA entity.
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//        );



 //       Department savedDepartment = departmentRepository.save(department);
        Optional<Department> optionalDepartment =
               departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode());

        if(optionalDepartment.isPresent()) {
            System.out.println("DepartmentCode with " + '"' + departmentDto.getDepartmentCode() +'"'  + " already exists for a Department");
            throw new DepartmentCodeAlreadyExistsException("DepartmentCode with " +  departmentDto.getDepartmentCode() + " already exists for a Department");
        }

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        // Convert savedDepartment Department JPA entity to DepartmentDto
//        DepartmentDto savedDepartmentDto = new DepartmentDto(
//                savedDepartment.getId(),
//                savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(),
//                savedDepartment.getDepartmentCode()
//        );

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Optional<Department> department = departmentRepository.findByDepartmentCode(departmentCode);

        // Convert department JPA entity to DepartmentDto
//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department.get());
        return departmentDto;
    }
}
