/**
 * 
 */
package com.gnanistore.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 504703
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthenticationResponseDto {
	private String authenticationToken;
	private User user;
}
