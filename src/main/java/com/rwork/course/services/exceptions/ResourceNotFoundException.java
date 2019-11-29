package com.rwork.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(Object id) {
		super("Resource not found. ID " + id);
	}

	private static final long serialVersionUID = 5980271211392915379L;

}
