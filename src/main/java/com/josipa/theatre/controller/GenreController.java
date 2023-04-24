package com.josipa.theatre.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import com.josipa.theatre.model.Genre;
import com.josipa.theatre.repository.GenreRepository;

@RestController
public class GenreController implements CommandLineRunner{

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public void run(String... args) throws Exception{

	
	Genre genre1=new Genre(1,"Melodrama");
	genreRepository.save(genre1);
	
	Genre genre2=new Genre(2,"Drama");
	genreRepository.save(genre2);

	Genre genre3=new Genre(3,"Comedy");
	genreRepository.save(genre3);
	Genre genre4=new Genre(4,"Tragedy");
	genreRepository.save(genre4);
	Genre genre5=new Genre(5,"Tragicomedy");
	genreRepository.save(genre5);


}
}
