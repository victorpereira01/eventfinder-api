package com.victorpereira.eventfinder.services.utils;

import com.victorpereira.eventfinder.models.Event;
import com.victorpereira.eventfinder.models.User;

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

	public static Event validateEventFields(Event event, Event obj) {
		if (event.getName() != null) {
			obj.setName(event.getName());
		}
		if (event.getState() != null) {
			obj.setState(event.getState());
		}
		if (event.getCity() != null) {
			obj.setCity(event.getCity());
		}
		if (event.getPlace() != null) {
			obj.setPlace(event.getPlace());
		}
		if (event.getInitialDate() != null) {
			obj.setInitialDate(event.getInitialDate());
		}
		if (event.getEndDate() != null) {
			obj.setEndDate(event.getEndDate());
		}
		return obj;
	}
}
