package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;


import com.example.demo.repo.JoeRepo;

import com.example.demo.user.Joe;

public class JoeServiceDB implements JoeService {
	
	private List<Joe> podcasts = new ArrayList<>();
	
	private JoeRepo repo;
	
	public JoeServiceDB(JoeRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Joe createPodcast(Joe podcast) {
		return this.repo.save(podcast);
	}

	@Override
	public Joe findPodcastByGuest(String guest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Joe findPodcastById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Joe findPodcastByNum(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Joe> podcasts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Joe> findPodcastByCat(String category) {
		return this.repo.findByCategory(category);

	}

	@Override
	public String deletePodcast(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Joe updatePodcast(int id, Joe podcast) {
		Joe found = this.repo.findById(id).get();
		// modify record
		found.setPodcast_Number(podcast.getPodcast_Number());
		found.setGuests(podcast.getGuests());
		found.setCategory(podcast.getCategory());

		// save it back to overwrite it
		Joe updated = this.repo.save(found);

		return updated;
	}
}
