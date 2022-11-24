package com.cts.player.main.service;

import java.sql.Timestamp;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.player.main.dao.PlayerDao;
import com.cts.player.main.entity.Player;
import com.cts.player.main.exception.PlayerException;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerDao playerDao;
	
	public Player addPlayer(Player player) throws PlayerException {
		boolean flag = validation(player);
		Timestamp date = player.getPlayerdob();
		LocalDate date1= LocalDate.now();
		int age = date1.getYear()-date.toLocalDateTime().getYear();
		if(age<18) {
			throw new PlayerException("Player age is below 18");
		}if(!player.getPlayerEmail().matches("^(.+)@(.+)$")) {
			throw new PlayerException("Please add a proper email");
		}
		if(!player.getPlayerPhone().matches("[0-9]{10}")) {
			throw new PlayerException("Please add a proper phone number");
		}
		player.setPlayerAge(age);
		if(flag==true) {
			Player player1 = playerDao.saveAndFlush(player);
			player1.setPlayerId(String.format("MS-%03d", player1.getId()));
			Player player2 = playerDao.saveAndFlush(player1);
			return player2;
		}else {
			throw new PlayerException("Player already exist please login");
		}
	}

	private boolean validation(Player player) {
		Player player1= playerDao.findByPlayerEmail(player.getPlayerEmail());
		if(player1==null) {
			return true;
		}else {
			return false;
		}
	}
	
	public Player findByEmailOrPlayerId(String id,String pwd) throws PlayerException {
		Player player = playerDao.findByPlayerEmail(id);
		if(player == null) {
			player = playerDao.findByPlayerId(id);
		}
		if(player == null) {
			throw new PlayerException("Invalid credentials");
		}else {
			if(player.getPlayerPwd().equals(pwd)) {
				return player;
			}else {
				throw new PlayerException("Invalid credentials");
			}
		}
		
	}
	
	
	public Player findByPlayerId(String id) throws PlayerException{
		
		Player player = playerDao.findByPlayerEmail(id);
		if(player == null) {
			player = playerDao.findByPlayerId(id);
		}
		if(player == null) {
			throw new PlayerException("Invalid credentials");
		}
		return player;
		
	}
	
   public Player findById(long id) throws PlayerException{
		
		return playerDao.findById(id).get();
		
	}

   public Player updatePlayer(Player player) {
	   return playerDao.saveAndFlush(player);
   }
}
