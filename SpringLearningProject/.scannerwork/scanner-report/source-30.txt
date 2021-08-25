/**
 * 
 */
package com.springlearning.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springlearning.address.Address;
import com.springlearning.address.AddressService;
import com.springlearning.exceptions.UserNotFoundException;


/**
 * @author 504703
 *
 */
@RestController
@RequestMapping(path="/springlearning")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private AddressService addressService;
	
	@GetMapping(path="/userlist")
	public List<UserEntity> getUsersList() {
		return userService.getUsersList();
	}
	
	@GetMapping(path="/user/{id}")
	public UserEntity getUser(@PathVariable("id") Integer userId) {
		Optional<UserEntity> user;
		try {
			user = userService.getUser(userId);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			throw new UserNotFoundException("user id "+userId+" not found");
		}
		return user.get();
	}
	
	@GetMapping(path="/user/{id}/addresses")
	public List<Address> getUserAddressList(@PathVariable("id") Integer userId){
		
		Optional<UserEntity> userDetails = userService.getUser(userId);
		
		return userDetails.get().getAddresses();
	}
	
	@PostMapping(path="/saveuser")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody UserEntity user) {
		UserEntity userResponse = userService.saveUser(user);
		
		user.getAddresses().stream().forEach(address -> addressService.saveAddress(userResponse.getUserid(), address));
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userResponse.getUserid()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path="/updateuser/{id}")
	public String updateUser(@PathVariable("id") Integer userid, @RequestBody UserEntity user) {
		userService.updateUser(userid,user);
		return "User "+userid+" updated";
	}
	
	@DeleteMapping(path="/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") Integer userid) {
		userService.deleteUser(userid);
		return "User "+userid+" Deleted Successfully";
	}
}
