package com.josipa.theatre.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.josipa.theatre.model.Actor;
import com.josipa.theatre.model.Genre;
import com.josipa.theatre.model.Play;
import com.josipa.theatre.repository.ActorRepository;
import com.josipa.theatre.repository.GenreRepository;
import com.josipa.theatre.repository.PlayRepository;

@Controller
public class PlayContoller {
	
	@Autowired
	private PlayRepository playRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index.html";
	}

	
	@GetMapping("/play/new")
	public String showNewPlayForm(Model model) {
		List<Genre> genres=genreRepository.findAll();
		List<Actor> actors= actorRepository.findAll();
		
		model.addAttribute("play",new Play());
		model.addAttribute("genres",genres);
		model.addAttribute("actors",actors);
		return "play_form";
	}
	
	@PostMapping("/play/save")
	public String savePlay(Play play) {
		
		playRepository.save(play);
		return "redirect:/play";
	}
	
	@GetMapping("/play")
	public String listPlays(Model model) {
		List<Play> plays=playRepository.findAll();
		
		model.addAttribute("plays",plays);
	
		return "play_list";
		
	}
	
	@GetMapping("/play/edit/{id}")
	public String showEditPlayForm(@PathVariable("id") Integer id, Model model) {
		
		Play play=playRepository.findById(id).get();
		
		model.addAttribute("play",play);
		
		List<Genre> genres=genreRepository.findAll();
		List<Actor> actors= actorRepository.findAll();
		
		model.addAttribute("genres",genres);
		model.addAttribute("actors",actors);
		return "play_form";
		
	}
	
	@GetMapping("/play/delete/{id}")
	public String deleteIngredient(@PathVariable("id") Integer id, Model model) {
	
		playRepository.deleteById(id);
		
		return "redirect:/play";

}

}
