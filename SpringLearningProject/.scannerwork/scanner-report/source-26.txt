/**
 * 
 */
package com.springlearning.limits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 504703
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Limits {
	@Getter @Setter private Integer minimum;
	@Getter @Setter private Integer maximum;
}	
