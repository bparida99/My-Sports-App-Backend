package com.cts.sports.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.sports.main.dao.SportsDao;
import com.cts.sports.main.entity.Sports;
import com.cts.sports.main.service.SportsService;

@SpringBootTest
class SportsServiceApplicationTests {

	@Autowired
	private SportsService service;
	
	@MockBean
	private SportsDao dao;
	
	
	@Test
	void addSportsTest() {
		Sports sports = new Sports(1l,"Cricket","20","9 AM");
		when(dao.saveAndFlush(sports)).thenReturn(sports);
		Sports sports1 = service.addSports(sports);
		assertEquals(sports, sports1);
	}
	
	@Test
	void findBySportsNameTest() {
		Sports sports = new Sports(1l,"Cricket","20","9 AM");
		List<Sports> list = new ArrayList<>();
		list.add(sports);
		when(dao.findBySportsName("Cricket")).thenReturn(list);
		
		List<Sports> list1 = service.findBySportsName("Cricket");
		assertEquals(list, list1);
		
	}

}
