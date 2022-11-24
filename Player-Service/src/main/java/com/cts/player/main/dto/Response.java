package com.cts.player.main.dto;

import java.util.Objects;

public class Response {
	
	private String msg;
	private Object obj;
	private long playerId;
	private String playerName;
	private String status;
	
	public Response() {
		super();
	}

	public Response(String msg, Object obj, long playerId, String playerName, String status) {
		super();
		this.msg = msg;
		this.obj = obj;
		this.playerId = playerId;
		this.playerName = playerName;
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(msg, obj, playerId, playerName, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		return Objects.equals(msg, other.msg) && Objects.equals(this.obj, other.obj) && playerId == other.playerId
				&& Objects.equals(playerName, other.playerName) && Objects.equals(status, other.status);
	}

	
}
