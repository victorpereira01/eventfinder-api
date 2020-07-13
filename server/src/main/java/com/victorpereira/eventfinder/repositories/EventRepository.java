package com.victorpereira.eventfinder.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.victorpereira.eventfinder.models.Event;
import com.victorpereira.eventfinder.models.User;

public interface EventRepository extends JpaRepository<Event, Integer>{

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Event obj WHERE obj.owner.id = :ownerId ORDER BY obj.initialDate")
	public List<Event> findEvents(@Param("ownerId")Integer owner_id);
	
	public default List<Event> subscribedEvents(List<Event> events, User user) {
		List<Event> list = new ArrayList<>();
		for(Event x : events) {
			if(x.getUsers().contains(user)) {
				list.add(x);
			}
		}
		return list;
	}
	
	@Transactional(readOnly = true)
	public Event findByName(String name);
}
