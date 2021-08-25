/**
 * 
 */
package com.gnanistore.rest.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 504703
 *
 */
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
	@Getter @Setter private String message;
	@Getter @Setter private String details;
	@Getter @Setter private Date timestamp;
}
