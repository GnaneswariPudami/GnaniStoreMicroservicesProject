/**
 * 
 */
package com.springlearning.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author 504703
 *
 */
@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webReq){ 
		List<String> details = new ArrayList<>(); 
		details.add(ex.getLocalizedMessage()); 
		ErrorResponse errorResp = new ErrorResponse("Internal Server Error", details); 
		return new ResponseEntity<Object>(errorResp, HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	 
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundExceptions(EntityNotFoundException ex, WebRequest wwebReq) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResp = new ErrorResponse("Entity Not Found", details);
		return new ResponseEntity<Object>(errorResp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest wwebReq) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResp = new ErrorResponse("User not found ", details);
		return new ResponseEntity<Object>(errorResp, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> details = ex.getAllErrors().stream()
									.map(ObjectError::getDefaultMessage)
									.collect(Collectors.toList());
		
		ErrorResponse errorResp = new ErrorResponse("Validation Failed", details);
		return new ResponseEntity<Object>(errorResp, HttpStatus.BAD_REQUEST);
	}
}
