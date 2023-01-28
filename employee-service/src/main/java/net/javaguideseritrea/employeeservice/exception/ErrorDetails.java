package net.javaguideseritrea.employeeservice.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {      //  ErrorDetails class to hold the custom error response

    private LocalDateTime timeStamp;    // This is the time when the exception occurred.

    private String message;             // This field contains the error message.

    private String path;           // this should be REST API path. For Example: "path": "/api/users/79"

    private String errorCode;

    // These are the fields the client wants in error response -  to hold the custom error response!
}

