package com.cts.player.main.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	@Column(name = "PLAYER_NAME")
	private String playerName;
	@Column(name = "PLAYER_DOB")
	private Timestamp playerdob;
	@Column(name= "PLAYER_AGE")
	private Integer playerAge;
	@Column(name = "PLAYER_EMAIL")
	private String playerEmail;
	@Column(name = "PLAYER_PHONE")
	private String playerPhone;
	@Column(name= "PLAYER_ID")
	private String playerId;
	@Column(name= "PAN_NO")
	private String pan;
	@Column(name= "PLAYER_PWD")
	private String playerPwd;
	
	public Player() {
		super();
	}

	public Player(Long id, String playerName, Timestamp playerdob, Integer playerAge, String playerEmail, String playerPhone,
			String playerId, String pan, String playerPwd) {
		super();
		this.id = id;
		this.playerName = playerName;
		this.playerdob = playerdob;
		this.playerAge = playerAge;
		this.playerEmail = playerEmail;
		this.playerPhone = playerPhone;
		this.playerId = playerId;
		this.pan = pan;
		this.playerPwd = playerPwd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Timestamp getPlayerdob() {
		return playerdob;
	}

	public void setPlayerdob(Timestamp playerdob) {
		this.playerdob = playerdob;
	}

	public Integer getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(Integer playerAge) {
		this.playerAge = playerAge;
	}

	public String getPlayerEmail() {
		return playerEmail;
	}

	public void setPlayerEmail(String playerEmail) {
		this.playerEmail = playerEmail;
	}

	public String getPlayerPhone() {
		return playerPhone;
	}

	public void setPlayerPhone(String playerPhone) {
		this.playerPhone = playerPhone;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPlayerPwd() {
		return playerPwd;
	}

	public void setPlayerPwd(String playerPwd) {
		this.playerPwd = playerPwd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pan, playerAge, playerEmail, playerId, playerName, playerPhone, playerPwd, playerdob);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(id, other.id) && Objects.equals(pan, other.pan)
				&& Objects.equals(playerAge, other.playerAge) && Objects.equals(playerEmail, other.playerEmail)
				&& Objects.equals(playerId, other.playerId) && Objects.equals(playerName, other.playerName)
				&& Objects.equals(playerPhone, other.playerPhone) && Objects.equals(playerPwd, other.playerPwd)
				&& Objects.equals(playerdob, other.playerdob);
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + ", playerdob=" + playerdob + ", playerAge="
				+ playerAge + ", playerEmail=" + playerEmail + ", playerPhone=" + playerPhone + ", playerId=" + playerId
				+ ", pan=" + pan + ", playerPwd=" + playerPwd + "]";
	}

	

}
