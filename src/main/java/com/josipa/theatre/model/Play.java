package com.josipa.theatre.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Play {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(nullable=false)
	private String title;
	
	
	private String director;

	private LocalDate time;
	
	private LocalTime time2;
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="genre_id", nullable=false)
    private Genre genre;
	
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
		  @JoinTable(name = "plays_actors",
		        joinColumns = { @JoinColumn(name = "play_id") },
		        inverseJoinColumns = { @JoinColumn(name = "actor_id") })
		  private List<Actor> actors = new ArrayList<>();


	
	
	
	public Play() {
		
	}












	public Play(int id, String title, String director, LocalDate time, LocalTime time2, Genre genre,
			List<Actor> actors) {
		
		this.id = id;
		this.title = title;
		this.director = director;
		this.time = time;
		this.time2 = time2;
		this.genre = genre;
		this.actors = actors;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}





	

	public LocalDate getTime() {
		return time;
	}





	public void setTime(LocalDate time) {
		this.time = time;
	}

	public List<Actor> getActors() {
		return actors;
	}


	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	public LocalTime getTime2() {
		return time2;
	}












	public void setTime2(LocalTime time2) {
		this.time2 = time2;
	}











	@Override
	public String toString() {
		return title+" " ;
	}
	
	
	
	
	
	
	

}
