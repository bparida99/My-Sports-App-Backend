package com.cts.booking.main.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOKINGS")
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private long id;
	@Column(name="PLAYER_ID")
	private long playerId;
	@Column(name="PLAYER_NAME")
	private String playerName;
	@Column(name="SPORTS_ID")
	private long sportsId;
	@Column(name="SPORTS_NAME")
	private String sportsName;
	@Column(name="TIME")
	private String time;
	@Column(name="BOOKING_DATE")
	private LocalDate bookingDate;
	public Bookings() {
		super();
	}
	public Bookings(long id, long playerId, String playerName, long sportsId, String sportsName, String time,
			LocalDate bookingDate) {
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
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
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
		Bookings other = (Bookings) obj;
		return Objects.equals(bookingDate, other.bookingDate) && id == other.id
				&& Objects.equals(playerId, other.playerId) && Objects.equals(playerName, other.playerName)
				&& sportsId == other.sportsId && Objects.equals(sportsName, other.sportsName)
				&& Objects.equals(time, other.time);
	}
	@Override
	public String toString() {
		return "Bookings [id=" + id + ", playerId=" + playerId + ", playerName=" + playerName + ", sportsId=" + sportsId
				+ ", sportsName=" + sportsName + ", time=" + time + ", bookingDate=" + bookingDate + "]";
	}
	
	
	
}
