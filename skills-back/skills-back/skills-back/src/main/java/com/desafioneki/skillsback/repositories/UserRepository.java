package com.desafioneki.skillsback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioneki.skillsback.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
