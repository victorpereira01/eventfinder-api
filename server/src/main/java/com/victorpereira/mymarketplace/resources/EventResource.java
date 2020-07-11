package com.victorpereira.mymarketplace.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victorpereira.mymarketplace.models.Event;
import com.victorpereira.mymarketplace.repositories.EventRepository;
import com.victorpereira.mymarketplace.resources.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/events")
public class EventResource {

	@Autowired
	private EventRepository eventRepo;

	
	@GetMapping
	public List<Event> findAll() {
		return eventRepo.findAll();
	}

	@GetMapping(value="/")
	public Event findByName(@RequestParam(value="name") String name) {
		return eventRepo.findByName(name);
	}
		
	@GetMapping(value = "/{id}")
	public Event findById(@PathVariable Integer id) {
		Optional<Event> user = eventRepo.findById(id);
		return user.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + Event.class.getName()));
	}
}