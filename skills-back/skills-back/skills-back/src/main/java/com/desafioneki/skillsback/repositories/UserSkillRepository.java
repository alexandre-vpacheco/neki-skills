package com.desafioneki.skillsback.repositories;

import java.util.List;

import com.desafioneki.skillsback.entities.UserSkill;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserSkillRepository extends CrudRepository<UserSkill, Integer> {
    @Query("SELECT us FROM UserSkill us WHERE us.user.id = :id_user")
    List<UserSkill> findByUserId(Integer id_user);
}

