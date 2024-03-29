package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;


import com.example.demo.repo.JoeRepo;
import com.example.demo.user.Joe;



@SpringBootTest
@ActiveProfiles("test")
public class JoeServiceDBUnitTest {

	@Autowired // injects the actual service from the context
	private JoeServiceDB service;

	@MockBean // tells Spring to make a 'fake' Dog Repo that we can program
	private JoeRepo repo;

	@Test
	void testUpdate() {
		// GIVEN
		int id = 1;

		Joe testPodcast = new Joe(id, 1664,"Josh Dubin","Activists", 5, "yes"); 
		Joe testNewPod = new Joe(id, 1664,"Josh Dubin, David Blaine","Activists", 5, "yes"); // new podcast data

		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testPodcast)); 
		Mockito.when(this.repo.save(new Joe(id, 1664,"Josh Dubin, David Blaine","Activists", 5, "yes"))).thenReturn(testNewPod);

		Joe actual = this.service.updatePodcast(id, testNewPod);
		// THEN
		Assertions.assertThat(actual).isEqualTo(testNewPod);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(new Joe(id, 1664,"Josh Dubin, David Blaine","Activists", 5, "yes"));
	}

	@Test
	void testDelete() {
		int id = 1;
		
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		
		assertThat(this.service.deletePodcast(id)).isEqualTo("Deleted: " + id);
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
		
		
	}
	
	
	
	@Test
	void testCreate() {
		//GIVEN
		Joe newPod = new Joe(1664,"Josh Dubin, David Blaine","Activists", 5, "yes");
		Joe savedPod = new Joe(1, 1664,"Josh Dubin, David Blaine","Activists", 5, "yes");
		//WHEN
		Mockito.when(this.repo.save(newPod)).thenReturn(savedPod);
		//THEN
		 assertThat(this.service.createPodcast(newPod)).isEqualTo(savedPod);
		 Mockito.verify(this.repo, Mockito.times(1)).save(newPod);
	
	
	}
	
	@Test
	void testGet() {
		List<Joe> testPodcasts = List.of(new Joe(1664,"Josh Dubin, David Blaine","Activists", 5, "yes"));

		
		Mockito.when(this.repo.findAll()).thenReturn(testPodcasts);

		assertThat(this.service.podcasts().equals(testPodcasts));

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
}