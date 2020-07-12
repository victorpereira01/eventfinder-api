package com.victorpereira.eventfinder.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_event")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String state;

	private String city;

	private String place;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date initialDate;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date endDate;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "tb_event_user", 
			joinColumns = @JoinColumn(name = "event_id"), 
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users = new ArrayList<>();

	public Event() {
	}

	public Event(Integer id, String name, String state, String city, String place, Date initialDate, Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.city = city;
		this.place = place;
		this.initialDate = initialDate;
		this.endDate = endDate;
	}
}