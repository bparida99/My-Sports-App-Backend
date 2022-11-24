package com.cts.sports.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.sports.main.entity.Sports;

@Repository
public interface SportsDao extends JpaRepository<Sports, Long>{

	public List<Sports> findBySportsName(String name);
}
