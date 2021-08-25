/**
 * 
 */
package com.gnanistore.address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gnaneswari.Pudami
 *
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {
	public List<Address> findByUserid(Integer userId);
}
