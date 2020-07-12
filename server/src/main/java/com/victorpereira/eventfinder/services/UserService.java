package com.victorpereira.eventfinder.services;

import org.springframework.stereotype.Service;

import com.victorpereira.eventfinder.dto.UserDTO;
import com.victorpereira.eventfinder.models.User;

@Service
public class UserService {

	public UserDTO toDto(User obj) {
		return new UserDTO(obj);
	}
}
