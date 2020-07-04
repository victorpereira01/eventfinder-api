package com.victorpereira.mymarketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorpereira.mymarketplace.models.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
