package com.example.demo.service;

import java.util.List;

import com.example.demo.user.Joe;

public interface JoeService {
	
	public Joe createPodcast(Joe podcast);
	
	public Joe findPodcastByGuest(String guest);
	
	public Joe findPodcastById(Integer id);
	
	public Joe findPodcastByNum(String podcast_Number);
	
	public List<Joe> findPodcastByCat(String category);
	
	public List<Joe> podcasts();
	
	public String deletePodcast(Integer id);

	public Joe updatePodcast(Integer podcast_Number, Joe podcast);
	
	public List<Joe> favoritesP();
	
	
	
	

}
