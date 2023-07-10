package com.josipa.theatre.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column
	String genreName;

	public Genre() {
		
	}
	public Genre(int id, String genreName) {
		
		this.id = id;
		this.genreName = genreName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
	
	@Override
	public String toString() {
		return genreName+" " ;
	}
	

	

}
