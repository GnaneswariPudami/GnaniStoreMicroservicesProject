/**
 * 
 */
package com.springlearning.address;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlearning.exceptions.UserNotFoundException;
import com.springlearning.user.UserEntity;
import com.springlearning.user.UserRepository;

/**
 * @author 504703
 *
 */
@Service
@Transactional
public class AddressService {
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Address saveAddress(Integer userId, Address address) {
		Optional<UserEntity> userDetails = userRepo.findById(userId);
		if(!userDetails.isPresent()) {
			throw new UserNotFoundException("User ID "+userId+" is not found");
		}
		System.out.println("Address before saving"+address);
		return addressRepo.save(address);
	}
	
	public List<Address> getAddressList(){
		return addressRepo.findAll();
	}

	public Address getAddressById(Integer addressId) {
		return addressRepo.getById(addressId);
	}

	public String deleteAddress(Integer addressId) {
		addressRepo.deleteById(addressId);
		return "Address "+ addressId +" deleted successfully";
	}
}
