package com.cts.player.main.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.player.main.config.jwt.AuthRequest;
import com.cts.player.main.config.jwt.JwtUtil;
import com.cts.player.main.dto.Response;
import com.cts.player.main.entity.Player;
import com.cts.player.main.exception.PlayerException;
import com.cts.player.main.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

    Logger logger = LoggerFactory.getLogger(PlayerController.class);
	
	
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private PlayerService playerService;
	

   
	
	@PostMapping("/registration")
	public Response registration(@RequestBody Player player) {
		
		Player player1;
		Response response = new Response();
		try {
			player1 = playerService.addPlayer(player);
			response.setObj(player1);
			response.setStatus("OK");
			response.setMsg("Success");
		} catch (PlayerException e) {
			logger.error(e.getMessage());
			response.setStatus("Error");
			response.setMsg(e.getMessage());
		}
		return response;
	}
	
	@PostMapping("/authenticate")
	public Response generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		Response response = new Response();
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
			Player player = playerService.findByPlayerId(authRequest.getUserName());
			response.setObj(jwtUtil.generateToken(authRequest.getUserName()));
			response.setPlayerId(player.getId());
			response.setPlayerName(player.getPlayerName());
			response.setStatus("OK");
			response.setMsg("SUCCESS");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			response.setObj("");
			response.setStatus("ERROR");
			response.setMsg("inavalid username/password");
		}
		
		return response;
	}
	
	@GetMapping("/checking")
    public String check() {
		return "working.....";
	}
	@GetMapping("/getPlayerData/{id}")
	public Response getPlayerDetails(@PathVariable long id) {
		Response response = new Response();
		try {
			Player player = playerService.findById(id);
			response.setObj(player);
			response.setStatus("OK");
			response.setMsg("SUCCESS");
		} catch (PlayerException e) {
			logger.error(e.getMessage());
			response.setObj("");
			response.setStatus("ERROR");
			response.setMsg(e.getMessage());
		}
		return response;
	}
	
	@PostMapping("/editPlayer")
	public Response updatePlayerDetails(@RequestBody Player player) {
		Response response = new Response();
		Player player1 = playerService.updatePlayer(player);
		response.setObj(player1);
		response.setStatus("OK");
		response.setMsg("SUCCESS");
		return response;
	}

}
