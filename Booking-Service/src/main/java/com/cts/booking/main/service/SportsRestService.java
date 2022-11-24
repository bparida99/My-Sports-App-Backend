package com.cts.booking.main.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cts.booking.main.dto.SportsDTO;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
@Component
public class SportsRestService {

	@Autowired
	private RestTemplate restTemplate;
	
	public SportsDTO getSportsDetails(long id) {
		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<SportsDTO> requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<SportsDTO> responseEntity= restTemplate.exchange("http://localhost:9091/sports/getById/"+id, 
				  org.springframework.http.HttpMethod.GET, requestEntity, SportsDTO.class);
        return responseEntity.getBody();
	}
	
}
