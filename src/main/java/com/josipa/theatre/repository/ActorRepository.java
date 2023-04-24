package com.josipa.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josipa.theatre.model.Actor;

public interface ActorRepository extends JpaRepository<Actor,Integer>{

}
