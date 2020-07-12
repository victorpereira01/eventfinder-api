package com.victorpereira.eventfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorpereira.eventfinder.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
