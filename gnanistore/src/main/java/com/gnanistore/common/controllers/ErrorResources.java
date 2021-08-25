/**
 * 
 */
package com.gnanistore.common.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gnaneswari Pudami
 *
 */
@RestController
public class ErrorResources {
	
	@RequestMapping("/errorpage")
	public String error(@RequestParam(value="type") String type,
			@RequestParam(value="status") String statuscode) {
		return "Error page returned. type="+type+" status="+statuscode;
	}
}
