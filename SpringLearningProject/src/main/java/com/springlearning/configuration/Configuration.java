/**
 * 
 */
package com.springlearning.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 504703
 *
 */
@Component
@ConfigurationProperties("spring-learning-project")
public class Configuration {
	@Getter @Setter private int minimum;
	@Getter @Setter private int maximum;
}
