package net.javaguideseritrea.employeeservice.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    // Within this EmployeeDto class, let's define the instance variables
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
