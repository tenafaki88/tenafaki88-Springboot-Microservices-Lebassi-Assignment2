package net.javaguideseritrea.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class EmployeeIdAlreadyExistsException extends RuntimeException {

    private String message;

    public EmployeeIdAlreadyExistsException(String message) {
        super(message);

    }


}


