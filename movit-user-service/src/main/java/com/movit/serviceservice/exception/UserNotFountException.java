package com.movit.serviceservice.exception;

public class UserNotFountException {
	private long id ;

	public UserNotFountException(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
