/**
 * 
 */
package com.hotelservice.exception;

public class ResourceNotFound extends RuntimeException{
	
	public ResourceNotFound(String msg) {
		super(msg);
	}
	
	public ResourceNotFound() {
		super("Resouce not found!");
	}
}
