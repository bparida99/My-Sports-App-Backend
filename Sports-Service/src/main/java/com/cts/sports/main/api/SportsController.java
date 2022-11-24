package com.cts.sports.main.api;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.sports.main.entity.Sports;
import com.cts.sports.main.exception.SportsException;
import com.cts.sports.main.service.SportsService;

@RestController
@RequestMapping("/sports")
//@CrossOrigin("*")
public class SportsController {

	@Autowired
	private SportsService sportsService;
	
	@PostMapping("/addSports")
	public Sports addSports(@RequestBody Sports sports) {
		return sportsService.addSports(sports);
	}
	
	@GetMapping("/getAll")
	public List<Sports> getAll(){
	   return sportsService.findAllSports();	
	}
	
	@GetMapping("getAllByName/{name}")
	public List<Sports> getAllByName(@PathVariable String name){
		return sportsService.findBySportsName(name);
	}
	
	@GetMapping("getById/{id}")
	public ResponseEntity<Sports> getAllByName(@PathVariable long id){
		try {
			return new ResponseEntity<>(sportsService.findBySportsId(id),HttpStatus.OK);
		} catch (SportsException e) {
			e.printStackTrace();
			return null;
		}
	}
}
