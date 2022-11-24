package com.cts.sports.main.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SPORTS")
public class Sports {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private long id;
	@Column(name="SPORTS_NAME")
	private String sportsName;
	@Column(name="TOTAL_AVAILABLE_SLOTS")
	private String totalAvailableSlots;
	@Column(name="TIME")
	private String time;
	
	public Sports() {
		super();
	}
	public Sports(long id, String sportsName, String totalAvailableSlots, String time) {
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
		Sports other = (Sports) obj;
		return id == other.id && Objects.equals(sportsName, other.sportsName) && Objects.equals(time, other.time)
				&& Objects.equals(totalAvailableSlots, other.totalAvailableSlots);
	}
	
	@Override
	public String toString() {
		return "Sports [id=" + id + ", sportsName=" + sportsName + ", totalAvailableSlots=" + totalAvailableSlots
				+ ", time=" + time + "]";
	}
	
	

}
