package com.cts.player.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.player.main.entity.Player;

@Repository
public interface PlayerDao extends JpaRepository<Player, Long>{

	public Player findByPlayerEmail(String playerEmail);
	
	public Player findByPlayerId(String playerId);
}
