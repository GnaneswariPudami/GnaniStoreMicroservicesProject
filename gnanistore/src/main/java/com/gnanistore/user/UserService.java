/**
 * 
 */
package com.gnanistore.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gnaneswari Pudami
 *
 */
@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> listAllUsers(){
		return userRepo.findAll();
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	public User getUserDetails(Integer userId) {
		return  userRepo.findById(userId).get();
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		
		if(userRepo.findByUsernameAndPassword(username, password) != null && userRepo.findByUsernameAndPassword(username, password).size() != 0) {
			System.out.println("userRepo.findByUsernameAndPassword(username, password).get(0) ::: "+userRepo.findByUsernameAndPassword(username, password).get(0));
			return (User) userRepo.findByUsernameAndPassword(username, password).get(0);
		}
		else {
			System.out.println("User not found :: "+username);
			return null;
		}
	}
}
