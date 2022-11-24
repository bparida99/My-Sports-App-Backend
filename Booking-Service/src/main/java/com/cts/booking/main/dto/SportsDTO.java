package com.cts.booking.main.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class SportsDTO {

	
	private long id;
	
	private String sportsName;
	
	private String totalAvailableSlots;
	
	private String time;
	
	public SportsDTO() {
		super();
	}
	public SportsDTO(long id, String sportsName, String totalAvailableSlots, String time) {
		super();
		this.id = id;
		this.sportsName = sportsName;
		this.totalAvailableSlots = totalAvailableSlots;
		this.time = time;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSportsName() {
		return sportsName;
	}
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}
	public String getTotalAvailableSlots() {
		return totalAvailableSlots;
	}
	public void setTotalAvailableSlots(String totalAvailableSlots) {
		this.totalAvailableSlots = totalAvailableSlots;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, sportsName, time, totalAvailableSlots);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SportsDTO other = (SportsDTO) obj;
		return id == other.id && Objects.equals(sportsName, other.sportsName) && Objects.equals(time, other.time)
				&& Objects.equals(totalAvailableSlots, other.totalAvailableSlots);
	}
	
	@Override
	public String toString() {
		return "Sports [id=" + id + ", sportsName=" + sportsName + ", totalAvailableSlots=" + totalAvailableSlots
				+ ", time=" + time + "]";
	}
	
	

}
