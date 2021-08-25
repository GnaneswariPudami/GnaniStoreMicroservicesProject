/**
 * 
 */
package com.gnanistore.rest.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gnanistore.user.UserNotFoundException;

/**
 * @author 504703
 *
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception{
		ExceptionResponse exceptionResp = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity(exceptionResp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException unfEx, WebRequest request) throws Exception{
		ExceptionResponse exceptionResp = new ExceptionResponse(unfEx.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity(exceptionResp,HttpStatus.NOT_FOUND);
	}
}
