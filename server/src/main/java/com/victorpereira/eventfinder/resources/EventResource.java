package com.victorpereira.eventfinder.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victorpereira.eventfinder.models.Event;
import com.victorpereira.eventfinder.services.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventResource {

	@Autowired
	private EventService eventService;

	@GetMapping
	public List<Event> findAll() {
		return eventService.findAll();
	}

	@GetMapping(value="/")
	public Event findByName(@RequestParam(value="name") String name) {
		return eventService.findByName(name);
	}
		
	@GetMapping(value = "/{id}")
	public Event findById(@PathVariable Integer id) {
		return eventService.findById(id);
	}
}