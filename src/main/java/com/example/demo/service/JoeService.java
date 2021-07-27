package com.example.demo.service;

import java.util.List;

import com.example.demo.user.Joe;

public interface JoeService {
	
	public Joe createPodcast(Joe podcast);
	
	public Joe findPodcastByGuest(String guest);
	
	public Joe findPodcastById(int id);
	
	public Joe findPodcastByNum(String number);
	
	public List<Joe> findPodcastByCat(String category);
	
	public List<Joe> podcasts();
	
	public String deletePodcast(int id);

	public Joe updatePodcast(int id, Joe podcast);
	
	public List<Joe> favoritesP();
	
	
	
	

}
