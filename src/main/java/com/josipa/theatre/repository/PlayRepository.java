package com.josipa.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josipa.theatre.model.Play;

public interface PlayRepository extends JpaRepository<Play,Integer>{

}
