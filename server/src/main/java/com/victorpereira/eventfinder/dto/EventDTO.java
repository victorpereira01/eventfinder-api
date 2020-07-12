package com.victorpereira.eventfinder.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.victorpereira.eventfinder.models.Event;

import lombok.Data;

@Data
public class EventDTO {

	private Integer id;

	private String name;

	private String state;

	private String city;

	private String place;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date initialDate;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date endDate;

	private UserDTO owner;

	public EventDTO() {
	}

	public EventDTO(Event event) {
		id = event.getId();
		name = event.getName();
		state = event.getState();
		city = event.getCity();
		place = event.getPlace();
		initialDate = event.getInitialDate();
		endDate = event.getEndDate();
	}
}