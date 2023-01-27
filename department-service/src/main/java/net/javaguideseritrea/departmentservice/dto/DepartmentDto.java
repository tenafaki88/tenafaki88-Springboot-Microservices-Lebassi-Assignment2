package net.javaguideseritrea.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long id;                        // private instance variables
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
