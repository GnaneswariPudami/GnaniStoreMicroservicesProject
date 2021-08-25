/**
 * 
 */
package com.gnanistore.address;

import java.util.List;
import java.util.stream.Stream;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Gnaneswari Pudami
 *
 */
@RestController
@RequestMapping(path = "/gnanistore")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Slf4j
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping(path = "/addresslist")
	public List<Address> listAddress(@RequestParam(value = "id") Integer userid){
		
		Stream<String> st = Stream.iterate("", (str) -> str + "x"); 
		
		log.info("st :: "+st.count());
		System.out.println("expression result :: "+st.limit(3).map(str -> str + "y"));
		
		log.info("userid : "+userid);
		return addressService.findAllByUserId(userid);
	}
	
	@PostMapping(path = "/saveaddress")
	public String saveAddress(@RequestBody Address address) {
		log.info("Saving new address details provided " +address);
		Address newAddress = addressService.saveAddress(address);
		return "Address saved successfully with Id"+newAddress.getAddressId()+" and address as "+newAddress.getAddress1()+" "+newAddress.getAddress2();
	}
	
	@DeleteMapping(path = "/deleteaddress/{id}")
	public String deleteAddress(@PathVariable("id") Integer addressId) {
		addressService.deleteAddressById(addressId);
		return "Address "+ addressId + "Deleted successfully";
	}
}
