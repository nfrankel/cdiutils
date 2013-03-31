package com.packtpub.learnvaadin.cdi.presenter;

import java.security.Principal;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.packtpub.learnvaadin.authentication.AuthenticationException;
import com.packtpub.learnvaadin.authentication.TwitterAuthenticationStrategy;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Notification;

/**
 * Login behavior delegates to a predefined authentication strategy.
 */
public class LoginBehavior {

	@Inject
	private TwitterAuthenticationStrategy authStrategy;

	public void handleLogin(@Observes LoginEvent event) {

		try {

			String pin = event.getPinValue();

			Principal user = authStrategy.authenticate(pin);

			VaadinSession.getCurrent().setAttribute(Principal.class, user);

			Notification.show(user.getName() + ", you're authenticated into Twaattin");

		} catch (AuthenticationException e) {

			Notification.show(e.getMessage());
		}
	}
}
