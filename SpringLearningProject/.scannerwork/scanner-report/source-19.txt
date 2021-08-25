/**
 * 
 */
package com.springlearning.address;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * @author 504703
 *
 */
@RestController
@RequestMapping(path = "/springlearning")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping(path = "/address/{addressId}")
	public Address getAddress(@PathVariable("addressId") Integer addressId) {
		return addressService.getAddressById(addressId);
	}
	
	@PostMapping(path = "/saveaddress/{userId}")
	public Integer saveAddress(@PathVariable("userId") Integer userId,@Valid @RequestBody Address address) {
		return addressService.saveAddress(userId, address).getAddressId();
	}
	
	@DeleteMapping(path = "/deleteaddress/{addressId}")
	public String deleteAddress(@PathVariable("addressId") Integer addressId) {
		return addressService.deleteAddress(addressId);
	}
}
