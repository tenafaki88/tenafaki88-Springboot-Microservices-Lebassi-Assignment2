package net.javaguideseritrea.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
      
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName,fieldValue));
        /**  "message": "User not found with id : '12'", ****/
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}


/**************************************
 * GET http://localhost:8082/api/users/25
 * OUTPUT:
 * 404 Not Found    14 ms   314 B
 * {
 *     "timestamp": "2023-01-15T03:55:08.765+00:00",
 *     "status": 404,
 *     "error": "Not Found",
 *     "message": "User not found with id : '25'",
 *     "path": "/api/users/25"
 * }
 *
 */

