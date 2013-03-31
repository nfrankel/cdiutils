package com.packtpub.learnvaadin.service;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

@SuppressWarnings("serial")
@ApplicationScoped
public class FakeTwitterService implements Serializable {

	public String getAuthenticationUrl() {

		return "http://fake.twitter.com/";
	}

	public String authenticate(String pin) {

		return pin;
	}
}
