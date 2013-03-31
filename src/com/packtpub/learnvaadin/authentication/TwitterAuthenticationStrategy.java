package com.packtpub.learnvaadin.authentication;

import java.security.Principal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.packtpub.learnvaadin.service.FakeTwitterService;

@ApplicationScoped
public class TwitterAuthenticationStrategy implements PinAuthenticationStrategy {

	@Inject
	private FakeTwitterService twitterService;

	@Override
	public Principal authenticate(String pin) throws AuthenticationException {

		if ("0".equals(pin)) {

			throw new AuthenticationException("Bad PIN");
		}

		String screenName = twitterService.authenticate(pin);

		return new User(screenName);
	}
}
