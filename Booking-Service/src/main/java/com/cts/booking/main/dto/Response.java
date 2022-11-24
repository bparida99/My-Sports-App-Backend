package com.cts.booking.main.dto;

import java.util.Objects;

public class Response {
	
	private String msg;
	private Object obj;
	private String status;
	
	public Response() {
		super();
	}

	public Response(String msg, Object obj, String status) {
		super();
		this.msg = msg;
		this.obj = obj;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(msg, obj, status);
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
		return Objects.equals(msg, other.msg) && Objects.equals(this.obj, other.obj)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Response [msg=" + msg + ", obj=" + obj + ", status=" + status + "]";
	}
	
	

}
