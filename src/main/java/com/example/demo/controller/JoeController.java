package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.service.JoeService;

import com.example.demo.user.Joe;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin
public class JoeController {
	
	

		
		// dependency
		
		private JoeService service;
		
		//spring injecting it into my class
		
		public JoeController(JoeService service) {
			super();
			this.service = service;
		}
		

		
		@GetMapping("/") // MAPS a GET request to "/" to this method
		public String hello() {
			return "Hello, My Dawgs!";
		}
		
//		@PostMapping("/createDog") // fancy
//		public void createDog(@RequestBody Dog dog) { // less fancy
//		// just Java
//			this.service.createDog(dog);
//		}
		
		@PostMapping("/createPodcast") // fancy
		public ResponseEntity<Joe> createPodcast(@RequestBody Joe podcast) { // less fancy
			Joe created = this.service.createPodcast(podcast);
			return new ResponseEntity<>(created, HttpStatus.CREATED); // body, code
		}
		
		
		
		@GetMapping("/getPodcastId/{id}")
		public ResponseEntity<Joe> getPodcastId(@PathVariable int id) {
			Joe body = this.service.findPodcastById(id);
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		
		
		@GetMapping("/podcasts")
		public List<Joe> podcasts() {
			return this.service.podcasts();
			
		}
		
		@DeleteMapping("/deletePodcast/{id}")
		public ResponseEntity<String> deletePodcast(@PathVariable int id) {
			String body = this.service.deletePodcast(id);
			return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
		}
		@GetMapping("/findByCategory/{category}")
		public List<Joe> findByCategory(@PathVariable String category){
			return this.service.findPodcastByCat(category);
		}
			



		

	//public Dog updateDog(@PathVariable int id, @RequestBody Dog dog ) { //newDog
//		return this.service.updateDog(id, dog);
//			
//			}
	@PutMapping("/updatePodcast/{id}")
	public ResponseEntity<Joe> updatePodcast(@PathVariable int id, @RequestBody Joe podcast ) { //newDog
		Joe body = this.service.updatePodcast(id, podcast);
		return new ResponseEntity<>(body,HttpStatus.ACCEPTED);
			
			}


//	@GetMapping("/findColour/{colour}")
//	public List<Dog> findByColour(@PathVariable String colour) {
//		return this.service.findByColour(colour);
//	}
	

}
