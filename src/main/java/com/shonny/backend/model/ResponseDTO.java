package com.shonny.backend.model;

public class ResponseDTO {
	private String message;
	private boolean sucessful;

	public ResponseDTO() {
		super();
	}

	public ResponseDTO(String message, boolean sucessful) {
		super();
		this.message = message;
		this.sucessful = sucessful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSucessful() {
		return sucessful;
	}

	public void setSucessful(boolean sucessful) {
		this.sucessful = sucessful;
	}

}
