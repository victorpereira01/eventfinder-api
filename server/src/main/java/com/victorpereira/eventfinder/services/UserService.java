package com.victorpereira.eventfinder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorpereira.eventfinder.dto.UserDTO;
import com.victorpereira.eventfinder.models.User;
import com.victorpereira.eventfinder.repositories.UserRepository;
import com.victorpereira.eventfinder.resources.exceptions.ObjectNotFoundException;
import com.victorpereira.eventfinder.resources.utils.Utils;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> user = userRepo.findById(id);
		return user.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + User.class.getName()));
	}
	
	public User insert(User user) {
		return userRepo.save(user);
	}
	
	public void deleteById(Integer id) {
		findById(id);
		userRepo.deleteById(id);
	}
	
	public User update(User user, Integer id) {
		User obj = findById(id);
		obj = Utils.validateUserFields(user, obj);
		return userRepo.save(obj);
	}
	
	public UserDTO toDto(User obj) {
		return new UserDTO(obj);
	}
}
