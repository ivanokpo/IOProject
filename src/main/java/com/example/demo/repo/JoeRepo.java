package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.user.Joe;

public interface JoeRepo extends JpaRepository<Joe, Integer> {

	
	 
		
		List<Joe> findByCategory(String category);
		
		List<Joe> findByGuests(String guests);

	
}
