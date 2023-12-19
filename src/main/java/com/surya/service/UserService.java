package com.surya.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surya.Exception.UserNotFoundException;
import com.surya.Model.User;
import com.surya.Model.UserRequest;
import com.surya.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(UserRequest userRequest) {
//		User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
//				userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		User user=new User();
		user.setUserId(userRequest.getUserId());
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setMobile(userRequest.getMobile());
		user.setGender(userRequest.getGender());
		user.setAge(userRequest.getAge());
		user.setNationality(userRequest.getNationality());

		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
	  List<User> users=userRepository.findAll();
	  return users;
	}

	public User getUser(int id) throws UserNotFoundException {
		User user=userRepository.findByUserId(id);
		if(user!=null) {
			return user;
	
		}
		else
		{
			throw new UserNotFoundException("user not found with the id:"+id);
		}
	
	}
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
		
		
	}

}
