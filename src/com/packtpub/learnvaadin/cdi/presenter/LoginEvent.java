package com.packtpub.learnvaadin.cdi.presenter;

public class LoginEvent {

	private final String pinValue;

	public LoginEvent(String pinValue) {
		this.pinValue = pinValue;
	}

	public String getPinValue() {
		return pinValue;
	}
}
