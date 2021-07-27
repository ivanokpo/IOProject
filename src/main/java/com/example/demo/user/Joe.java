package com.example.demo.user;

import java.util.Objects;

import javax.persistence.Column;

public class Joe {
	
	@Column(name = "podcast_Number", unique = true)
	private int podcast_Number;
	
	private String guests;
	
	private String category;
	
	private int id;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPodcast_Number() {
		return podcast_Number;
	}

	public void setPodcast_Number(int podcast_Number) {
		this.podcast_Number = podcast_Number;
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
	
	

	public Joe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Joe(int id, int podcast_Number, String guests, String category) {
		super();
		this.podcast_Number = podcast_Number;
		this.guests = guests;
		this.category = category;
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		return "JRE Podcast, Episode: " + podcast_Number + ", With guests " + guests + ", category: " + category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, guests, podcast_Number);
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
				&& Objects.equals(podcast_Number, other.podcast_Number);
	}
	
	 
	
	

}
