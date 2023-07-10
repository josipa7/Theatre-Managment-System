package com.josipa.theatre.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private String contact;
	
	@Column
	private String biography;
	 @ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "actors")
		  @JsonIgnore
		  private List<Play> plays = new ArrayList<>();
	

	public Actor() {
		
	}






	public Actor(int id, String name, String surname, String contact, String biography, List<Play> plays) {
	
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.contact = contact;
		this.biography = biography;
		this.plays = plays;
	}






	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getBiography() {
		return biography;
	}



	public void setBiography(String biography) {
		this.biography = biography;
	}



	public List<Play> getPlays() {
		return plays;
	}



	public void setPlays(List<Play> plays) {
		this.plays = plays;
	}
	
	
	@Override
	public String toString() {
		return name+" " + surname;
	}
	






	
	
	
	
	
	

}
