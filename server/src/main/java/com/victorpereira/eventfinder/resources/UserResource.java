package com.victorpereira.eventfinder.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorpereira.eventfinder.dto.EventDTO;
import com.victorpereira.eventfinder.models.Event;
import com.victorpereira.eventfinder.models.User;
import com.victorpereira.eventfinder.services.EventService;
import com.victorpereira.eventfinder.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EventService eventService;

	// Only for testing
	@GetMapping()
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Integer id) {
		return userService.findById(id);
	}

	@PostMapping
	public User insert(@RequestBody User user) {
		return userService.insert(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		userService.deleteById(id);
	}

	@PutMapping(value = "/{id}")
	public User update(@RequestBody User user, @PathVariable Integer id) {
		return userService.update(user, id);
	}

	// Create event via user
	@PostMapping(value = "/{id}/events")
	public Event createEvent(@RequestBody Event event, @PathVariable Integer id) {
		return eventService.createEvent(event, findById(id));
	}

	// Get events from a user
	@GetMapping(value = "/{id}/events")
	public List<EventDTO> getUserEvents(@PathVariable Integer id) {
		return eventService.getUserEvents(id);
	}

	// Delete an event via user
	@DeleteMapping(value = "/{id}/events/{event_id}")
	public void deleteUserEvent(@PathVariable Integer id, @PathVariable Integer eventId) {
		eventService.deleteUserEvent(id, eventId);
	}

	// Updating an event via user
	@PutMapping(value = "/{id}/events/{event_id}")
	public Event updateUserEvent(@RequestBody Event event, @PathVariable Integer id, @PathVariable Integer eventId) {
		return eventService.updateUserEvent(event, id, eventId);
	}
	
	// Get subscribed events of a user
	@GetMapping(value="/{id}/subevents") 
	public List<Event> getUserSubscribedEvents(@PathVariable Integer id) {
		return eventService.getUserSubscribedEvents(eventService.findAll(), findById(id));
	}
	
	// Delete a subscribed event of a user
	@DeleteMapping(value="/{id}/subevents/{event_id}")
	public void deleteUserSubscribedEvent(@PathVariable Integer id, @PathVariable Integer event_id) {
		List<Event> list = eventService.getUserSubscribedEvents(eventService.findAll(), findById(id));
		eventService.findAndDelete(list, event_id);
	}
}
