package com.victorpereira.mymarketplace.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.victorpereira.mymarketplace.models.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Event obj WHERE obj.owner.id = :ownerId ORDER BY obj.initialDate")
	public List<Event> findEvents(@Param("ownerId")Integer owner_id);
	
	@Transactional(readOnly = true)
	public Event findByName(String name);
}
