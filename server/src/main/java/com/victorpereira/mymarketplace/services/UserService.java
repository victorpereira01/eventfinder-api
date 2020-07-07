package com.victorpereira.mymarketplace.services;

import org.springframework.stereotype.Service;

import com.victorpereira.mymarketplace.dto.UserDTO;
import com.victorpereira.mymarketplace.models.User;

@Service
public class UserService {

	public UserDTO toDto(User obj) {
		return new UserDTO(obj);
	}
	
}
