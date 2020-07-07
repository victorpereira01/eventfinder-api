package com.victorpereira.mymarketplace.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.victorpereira.mymarketplace.models.Event;

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

	public EventDTO(Event event ) {
		id = event.getId();
		name = event.getName();
		state = event.getState();
		city = event.getCity();
		place = event.getPlace();
		initialDate = event.getInitialDate();
		endDate = event.getEndDate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public UserDTO getOwner() {
		return owner;
	}

	public void setOwner(UserDTO owner) {
		this.owner = owner;
	}
}