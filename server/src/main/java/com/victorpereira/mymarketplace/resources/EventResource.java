package com.victorpereira.mymarketplace.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorpereira.mymarketplace.models.Event;
import com.victorpereira.mymarketplace.models.User;
import com.victorpereira.mymarketplace.repositories.EventRepository;
import com.victorpereira.mymarketplace.resources.exceptions.ObjectNotFoundException;
import com.victorpereira.mymarketplace.resources.utils.Utils;

@RestController
@RequestMapping(value="/events")
public class EventResource {
	
	@Autowired
	private EventRepository eventRepo;
	
	@GetMapping
	public List<Event> findAll(){
		return eventRepo.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Event findById(@PathVariable Integer id) {
		Optional<Event> user = eventRepo.findById(id);
		return user.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + Event.class.getName()));
	}
	
	@PostMapping
	public Event insert(@RequestBody Event event) {
		return eventRepo.save(event);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Integer id) {
		Event user = findById(id);
		eventRepo.delete(user);
	}

	@PutMapping(value = "/{id}")
	public Event update(@RequestBody Event event, @PathVariable Integer id) {
		Event obj = findById(id);
		obj = Utils.validateEventFields(event, obj);
		
		return eventRepo.save(obj);
	}
}