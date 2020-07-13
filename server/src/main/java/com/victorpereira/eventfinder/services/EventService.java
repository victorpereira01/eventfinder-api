package com.victorpereira.eventfinder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.victorpereira.eventfinder.dto.EventDTO;
import com.victorpereira.eventfinder.models.Event;
import com.victorpereira.eventfinder.models.User;
import com.victorpereira.eventfinder.repositories.EventRepository;
import com.victorpereira.eventfinder.resources.exceptions.ObjectNotFoundException;
import com.victorpereira.eventfinder.resources.utils.Utils;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private UserService userService;
	
	public List<Event> findAll() {
		return eventRepo.findAll();
	}
	
	public Event findByName(String name) {
		return eventRepo.findByName(name);
	}
	
	public List<Event> findEvents(Integer id) {
		return eventRepo.findEvents(id);
	}
	
	public Event findById(@PathVariable Integer id) {
		Optional<Event> user = eventRepo.findById(id);
		return user.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + Event.class.getName()));
	}
	
	public void findAndDelete(List<Event> events, Integer id) {
		for(Event e : events) {
			if(e.getId() == id) {
				eventRepo.deleteById(id);
				break;
			}
		}
	}
	
	public Event insert(Event event) {
		return eventRepo.save(event);
	}
	
	public void deleteById(Integer id) {
		findById(id);
		eventRepo.deleteById(id);
	}
	
	public Event createEvent(Event event, User user) {
		event.setOwner(user);
		return eventRepo.save(event);
	}
	
	public List<EventDTO> getUserEvents(Integer id) {
		List<Event> list = findEvents(id);
		List<EventDTO> listDto = list.stream().map(obj -> new EventDTO(obj)).collect(Collectors.toList());
		for (EventDTO x : listDto) {
			x.setOwner(userService.toDto(userService.findById(id)));
		}
		return listDto;
	}
	
	public void deleteUserEvent(Integer id, Integer eventId) {
		List<EventDTO> listDto = getUserEvents(id);
		List<Event> list = new ArrayList<>();
		for(EventDTO e : listDto) {
			list.add(toEvent(e));
		}
		findAndDelete(list, eventId);
	}
	
	public Event updateUserEvent(Event event, Integer id, Integer eventId) {
		List<EventDTO> listDto = getUserEvents(id);
		for (EventDTO e : listDto) {
			if (e.getId() == eventId) {
				Event obj = toEvent(e);
				obj.setOwner(userService.findById(id));
				obj = Utils.validateEventFields(event, obj);
				return insert(obj);
			}
		}
		return null;
	}
	
	public List<Event> getUserSubscribedEvents(List<Event> events, User user) {
		return eventRepo.subscribedEvents(events, user);
	}	
	
	public Event toEvent(EventDTO eventDto) {
		return new Event(eventDto.getId(), eventDto.getName(), eventDto.getState(), eventDto.getCity(),
				eventDto.getPlace(), eventDto.getInitialDate(), eventDto.getEndDate());
	}
}
