package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;


import com.example.demo.repo.JoeRepo;

import com.example.demo.user.Joe;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class JoeServiceDB implements JoeService {
	
	private List<Joe> podcasts = new ArrayList<>();
	private List<Joe> favorites = new ArrayList<>();
	
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
	public Joe findPodcastById(Integer id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Joe findPodcastByNum(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Joe> podcasts() {
		return this.repo.findAll();
	}
	
	public List<Joe> findPodcastByCat(String category) {
		return this.repo.findByCategory(category);

	}

	@Override
	public String deletePodcast(Integer id) {
		this.repo.deleteById(id);
		
		if (this.repo.existsById(id)) {
			return "Not deleted: " + id;
		} else {
			return "Deleted: " + id;
		}
	}

	@Override
	public Joe updatePodcast(Integer id, Joe podcast) {
		Joe found = this.repo.findById(id).get();
		// modify record
		found.setPodcastNumber(podcast.getPodcastNumber());
		found.setGuests(podcast.getGuests());
		found.setCategory(podcast.getCategory());
		found.setRating(podcast.getRating());
		found.setFavorite(podcast.getFavorite());

		// save it back to overwrite it
		Joe updated = this.repo.save(found);

		return updated;
	}
	
	@Override
	public List<Joe> favoritesP(){
		for(int i = 0 ; i < podcasts.size() ; i++) {
			if(podcasts.get(i).getRating() > 4) {
				favorites.add(podcasts.get(i));
			}
		}
		return favorites;
	}
	
	public List<Joe> findByCategory(String category){
		return this.repo.findByCategory(category);
	}

}
