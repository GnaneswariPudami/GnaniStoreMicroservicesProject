/**
 * 
 */
package com.gnanistore.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gnaneswari.Pudami
 *
 */
@Service
@Transactional
@Slf4j
public class AddressService {
	@Autowired
	AddressRepository addressRepo;
	
	public List<Address> findAllByUserId(Integer userId){
		return addressRepo.findByUserid(userId);
	}
	
	public Address saveAddress(Address address) {
		log.info("In AddressService.. Saving new address details provided" +address.getAddress1()+" "+address.getAddress2());
		return addressRepo.save(address);
	}
	
	public void deleteAddressById(Integer addressId) {
		addressRepo.deleteById(addressId);;
	}	
}
