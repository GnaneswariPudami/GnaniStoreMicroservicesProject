/**
 * 
 */
package com.springlearning.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 504703
 *
 */

public interface UserRepository extends JpaRepository<UserEntity,Integer>{

}
