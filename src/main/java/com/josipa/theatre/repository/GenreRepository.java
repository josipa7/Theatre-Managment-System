package com.josipa.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josipa.theatre.model.Genre;

public interface GenreRepository extends JpaRepository<Genre,Integer>{

}
