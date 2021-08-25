/**
 * 
 */
package com.gnanistore.user;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
/*import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gnanistore.address.AddressService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gnaneswari Pudami
 *
 */

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value="/gnanistore")
@Slf4j
public class UserAuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/userslist")
	public List<User> usersList() {
		System.out.println("Accessing Userslist");
		return userService.listAllUsers();
	}
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@RequestBody User user) {
		User userResponse = userService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userResponse.getUserid()).toUri();
		
		System.out.println("ResponseEntity.created(location).build() :: "+ResponseEntity.created(location).build());
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/login", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public AuthenticationResponseDto authenticate(
				@RequestParam(value="username") String username, 
				@RequestParam(value="password") String password) {
		
		User user = userService.findByUsernameAndPassword(username, password);
		
		if(user==null)
			throw new UserNotFoundException("username "+username+" not found");
		
		System.out.println("user Firstname details :::::"+user.getFirstname());
		System.out.println("user Lastname details :::::"+user.getLastname());

		String authenticationToken = createAuthenticationToken();
		return new AuthenticationResponseDto(authenticationToken, user);
	}
	
	private String createAuthenticationToken() {
		return UUID.randomUUID().toString();
	}	
}
