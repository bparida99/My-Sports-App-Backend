package com.cts.booking.main.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BookingDTO {

	
	private long id;
	
	private long playerId;
	private String playerName;
	private long sportsId;
	private String sportsName;
	private String time;
	private Timestamp bookingDate;
	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingDTO(long id, long playerId, String playerName, long sportsId, String sportsName, String time,
			Timestamp bookingDate) {
		super();
		this.id = id;
		this.playerId = playerId;
		this.playerName = playerName;
		this.sportsId = sportsId;
		this.sportsName = sportsName;
		this.time = time;
		this.bookingDate = bookingDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public long getSportsId() {
		return sportsId;
	}
	public void setSportsId(long sportsId) {
		this.sportsId = sportsId;
	}
	public String getSportsName() {
		return sportsName;
	}
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Timestamp getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, id, playerId, playerName, sportsId, sportsName, time);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingDTO other = (BookingDTO) obj;
		return Objects.equals(bookingDate, other.bookingDate) && id == other.id && playerId == other.playerId
				&& Objects.equals(playerName, other.playerName) && sportsId == other.sportsId
				&& Objects.equals(sportsName, other.sportsName) && Objects.equals(time, other.time);
	}
	
}
