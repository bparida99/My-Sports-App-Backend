package com.cts.sports.main.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sports.main.dao.SportsDao;
import com.cts.sports.main.entity.Sports;
import com.cts.sports.main.exception.SportsException;

@Service
public class SportsService {

	
	@Autowired
	private SportsDao sportsDao;
	
	public Sports addSports(Sports sports) {
		return sportsDao.saveAndFlush(sports);
	}
	
	public List<Sports> findAllSports() {
		List<Sports> allSports = sportsDao.findAll();
		return allSports.stream().collect(Collectors.groupingBy(Sports::getSportsName,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingLong(Sports::getId)),
						s->s.get()))).values().stream().toList();
	}
	
	public List<Sports> findBySportsName(String name){
		return sportsDao.findBySportsName(name);
	}
	
	public Sports findBySportsId(long id) throws SportsException{
		Sports sports = sportsDao.findById(id).get();
		if(sports==null) {
			throw new SportsException("Sports not found");
			
		}
		return sports;
	}
}
