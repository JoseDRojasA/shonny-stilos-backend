package com.shonny.backend.model;

public class AppUserPassDTO {
	private String oldPass;
	private String newPass;

	public AppUserPassDTO() {
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
}

