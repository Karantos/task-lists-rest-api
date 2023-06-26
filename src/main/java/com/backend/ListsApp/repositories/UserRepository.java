package com.backend.ListsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ListsApp.entities.User;

public interface UserRepository extends JpaRepository <User, Long> {

}