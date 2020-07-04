package com.victorpereira.mymarketplace.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorpereira.mymarketplace.models.User;
import com.victorpereira.mymarketplace.repositories.UserRepository;
import com.victorpereira.mymarketplace.resources.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserRepository userRepo;

	@GetMapping()
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Integer id) {
		Optional<User> user = userRepo.findById(id);
		return user.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + User.class.getName()));
	}
	
	@PostMapping
	public User insert(@RequestBody User user) {
		return userRepo.save(user);
	}

}
