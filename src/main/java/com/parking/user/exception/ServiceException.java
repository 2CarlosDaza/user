package com.parking.user.exception;

public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private long errorCode;
	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(long errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public long getErrorCode() {
		return errorCode;
	}
}
