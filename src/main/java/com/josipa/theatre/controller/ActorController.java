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
import com.josipa.theatre.repository.PlayRepository;


@Controller
public class ActorController {
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private PlayRepository playRepository;
	

	
	@GetMapping("/actor/new")
	public String showNewActorForm(Model model) {
		
		
		model.addAttribute("actor",new Actor());
		
		return "actor_form";
	}
	
	@PostMapping("/actor/save")
	public String saveActor(Actor actor) {
		
		actorRepository.save(actor);
		return "redirect:/actor";
	}
	
	@GetMapping("/actor")
	public String listActors(Model model) {
		List<Actor> actors= actorRepository.findAll();
		
		model.addAttribute("actors",actors);
	
		return "actor_list";
		
	}
	
	@GetMapping("/actor/edit/{id}")
	public String showEditActorForm(@PathVariable("id") Integer id, Model model) {
		
		Actor actor=actorRepository.findById(id).get();
		
		model.addAttribute("actor",actor);
		
		
		

		
		return "actor_form";
		
	}
	
	@GetMapping("/actor/delete/{id}")
	public String deleteActor(@PathVariable("id") Integer id, Model model) {
	
		actorRepository.deleteById(id);
		
		return "redirect:/actor";

}
}



