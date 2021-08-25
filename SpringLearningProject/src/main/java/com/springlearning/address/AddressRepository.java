/**
 * 
 */
package com.springlearning.address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 504703
 *
 */
public interface AddressRepository extends JpaRepository<Address, Integer>{

	
	//public List<Address> findByUser(Integer userId);

}
