package com.cts.player.main.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.player.main.dao.PlayerDao;
import com.cts.player.main.entity.Player;

@Service
public class PlayerDetailsService implements UserDetailsService{
	
	@Autowired
	private PlayerDao dao;
    
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("PLAYER"));
		Player player = dao.findByPlayerEmail(username);
		if(player==null) {
			player = dao.findByPlayerId(username);
		}
		return new User(player.getPlayerEmail(),player.getPlayerPwd(),authorities);
	}

}
