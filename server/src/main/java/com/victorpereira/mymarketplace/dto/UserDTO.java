package com.victorpereira.mymarketplace.dto;

import java.io.Serializable;

import com.victorpereira.mymarketplace.models.User;

import lombok.Data;

@Data
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	public UserDTO() {
	}

	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
	}
}
