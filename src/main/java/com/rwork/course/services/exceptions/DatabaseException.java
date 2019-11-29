package com.rwork.course.services.exceptions;

public class DatabaseException extends RuntimeException{

	public DatabaseException(String msg) {
		super(msg);
	}
	
	private static final long serialVersionUID = 1L;
}
