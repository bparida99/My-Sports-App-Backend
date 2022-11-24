package com.cts.player.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.player.main.dao.PlayerDao;
import com.cts.player.main.entity.Player;
import com.cts.player.main.exception.PlayerException;
import com.cts.player.main.service.PlayerService;

@SpringBootTest
class PlayerServiceApplicationTests {
	
	@Autowired
	private PlayerService service;
	
	@MockBean
	private PlayerDao dao;

	@Test
	void contextLoads() {
	}
    
	@Test
	void findByEmailOrPlayerIdTest() throws PlayerException {
		Player player = new Player(1l,"Biswo",null,24,"biswojitp11@gmail.com","9938864907","MS-101","ABCD","1234");
		
		when(dao.findByPlayerEmail("biswojitp11@gmail.com")).thenReturn(player);
		
		Player player1= service.findByEmailOrPlayerId("biswojitp11@gmail.com", "1234");
		assertEquals(player, player1);
		
		when(dao.findByPlayerId("MS-101")).thenReturn(player);
		Player player2= service.findByEmailOrPlayerId("MS-101", "1234");
		assertEquals(player, player2);
		
	}
	
	@Test
	void findByPlayerIdTest() throws PlayerException {
		Player player = new Player(1l,"Biswo",null,24,"biswojitp11@gmail.com","9938864907","MS-101","ABCD","1234");
		
		when(dao.findByPlayerEmail("biswojitp11@gmail.com")).thenReturn(player);
		
		Player player1= service.findByPlayerId("biswojitp11@gmail.com");
		assertEquals(player, player1);
		
		when(dao.findByPlayerId("MS-101")).thenReturn(player);
		Player player2= service.findByPlayerId("MS-101");
		assertEquals(player, player2);
		
	}
}
