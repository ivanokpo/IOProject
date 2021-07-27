package com.example.demo.user;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Entity;

@Entity
public class Joe {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Integer id;
	
	@Column(unique = true)
	private Integer podcastNumber;
	
	private String guests;
	
	private String category;
	
	
	
	private int rating;
	
	private String favorite;
	
	
	
	

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPodcastNumber() {
		return podcastNumber;
	}

	public void setPodcastNumber(int podcastNumber) {
		this.podcastNumber = podcastNumber;
	}

	public String getGuests() {
		return guests;
	}

	public void setGuests(String guests) {
		this.guests = guests;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	
	
	

	public Joe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Joe(int id, int podcast_Number, String guests, String category, int rating, String favorite) {
		super();
		this.podcastNumber = podcast_Number;
		this.guests = guests;
		this.category = category;
		this.id = id;
		this.rating = rating;
		this.setFavorite(favorite);
	}
	
	

	public String toString() {
		return "JRE Podcast, Episode: " + podcastNumber + ", With guests " + guests + ", category: " + category + " with a rating of " + rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, guests, podcastNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joe other = (Joe) obj;
		return Objects.equals(category, other.category) && Objects.equals(guests, other.guests)
				&& podcastNumber == other.podcastNumber && rating == other.rating;
	}

	
	 
	
	

}
