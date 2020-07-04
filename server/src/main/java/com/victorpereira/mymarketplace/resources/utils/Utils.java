package com.victorpereira.mymarketplace.resources.utils;

import com.victorpereira.mymarketplace.models.User;

public class Utils {

	public static User validateUserFields(User user, User obj) {
		if (user.getName() != null) {
			obj.setName(user.getName());
		}
		if (user.getEmail() != null) {
			obj.setEmail(user.getEmail());
		}
		if (user.getUsername() != null) {
			obj.setUsername(user.getUsername());
		}
		if (user.getPassword() != null) {
			obj.setPassword(user.getPassword());
		}
		return obj;
	}
}
