package com.victorpereira.eventfinder.services;

import org.springframework.stereotype.Service;

import com.victorpereira.eventfinder.dto.EventDTO;
import com.victorpereira.eventfinder.models.Event;

@Service
public class EventService {

	public Event toEvent(EventDTO eventDto) {
		return new Event(eventDto.getId(), eventDto.getName(), eventDto.getState(), eventDto.getCity(),
				eventDto.getPlace(), eventDto.getInitialDate(), eventDto.getEndDate());
	}
}
