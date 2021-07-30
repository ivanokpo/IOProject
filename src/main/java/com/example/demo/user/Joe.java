package com.example.demo.user;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Entity;

@Entity
public class Joe {
	
	@Override
	public String toString() {
		return "Joe [id=" + id + ", podcast_Number=" + podcast_Number + ", guests=" + guests + ", category=" + category
				+ ", rating=" + rating + ", favorite=" + favorite + "]";
	}

	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Integer id;
	
	@Column(unique = true)
	private Integer podcast_Number;
	
	private String guests;
	
	private String category;
	
	
	
	private Integer rating;
	
	private String favorite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPodcastNumber() {
		return podcast_Number;
	}

	public void setPodcastNumber(Integer podcast_Number) {
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

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	public Joe(Integer podcast_Number, String guests, String category, Integer rating, String favorite) {
		super();
		this.podcast_Number = podcast_Number;
		this.guests = guests;
		this.category = category;
		this.rating = rating;
		this.favorite = favorite;
	}

	public Joe(Integer id, Integer podcast_Number, String guests, String category, Integer rating, String favorite) {
		super();
		this.id = id;
		this.podcast_Number = podcast_Number;
		this.guests = guests;
		this.category = category;
		this.rating = rating;
		this.favorite = favorite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, favorite, guests, id, podcast_Number, rating);
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
		return Objects.equals(category, other.category) && Objects.equals(favorite, other.favorite)
				&& Objects.equals(guests, other.guests) && id == other.id && podcast_Number == other.podcast_Number
				&& rating == other.rating;
	}

	public Joe() {
		super();
	}
	
	
	
}

	