/**
 * 
 */
package com.springlearning.limits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlearning.configuration.Configuration;

/**
 * @author 504703
 *
 */
@RestController
@RequestMapping(path="/springlearning")
public class LimitsController {
	@Autowired
	private Configuration config;
	
	@GetMapping(path="/limits")
	public Limits limitsFromConfigServer() {
		return new Limits(config.getMinimum(), config.getMaximum());
	}
}
