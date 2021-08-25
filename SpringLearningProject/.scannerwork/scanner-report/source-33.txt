/**
 * 
 */
package com.springlearning.user;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlearning.exceptions.UserNotFoundException;

/**
 * @author 504703
 *
 */
@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public List<UserEntity> getUsersList() {
		return userRepo.findAll();
	}
	
	public UserEntity saveUser(UserEntity user) {
		return userRepo.save(user);
	}

	public UserEntity updateUser(Integer userId, UserEntity user) {
		return userRepo.save(user);
	}
	
	public void deleteUser(Integer userId) {
		userRepo.deleteById(userId);
	}

	public Optional<UserEntity> getUser(Integer userId) throws EntityNotFoundException{
		Optional<UserEntity> userDetails = userRepo.findById(userId);
		if(!userDetails.isPresent()) {
			throw new UserNotFoundException("user id "+userId+" not found");
		}
			
		return userDetails;
	}
}
