package com.victorpereira.mymarketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorpereira.mymarketplace.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
