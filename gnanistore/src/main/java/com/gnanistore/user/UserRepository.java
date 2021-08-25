/**
 * 
 */
package com.gnanistore.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gnaneswari Pudami
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{

	/**Get UserDetails matching username and password
	 * @param username
	 * @param password
	 * @return
	 */
	List<User> findByUsernameAndPassword(String username, String password);
	
}
