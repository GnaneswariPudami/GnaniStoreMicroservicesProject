/**
 * 
 */
package com.springlearning.exceptions;

import java.security.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 504703
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	
	@Getter @Setter private String message;
	@Getter @Setter private List<String> details;
}
