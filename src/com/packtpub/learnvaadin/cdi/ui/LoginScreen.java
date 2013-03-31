package com.packtpub.learnvaadin.cdi.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.vaadin.virkki.cdiutils.componentproducers.Preconfigured;

import com.packtpub.learnvaadin.cdi.presenter.LoginEvent;
import com.packtpub.learnvaadin.service.FakeTwitterService;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Link;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginScreen extends VerticalLayout implements ClickListener {

	@Inject
	private javax.enterprise.event.Event<LoginEvent> eventManager;

	@Inject
	@Preconfigured(caption = "Get PIN")
	private Link twitterLink;

	@Inject
	@Preconfigured(caption = "Submit")
	private Button submitButton;

	@Inject
	@Preconfigured
	private TextField pinField;

	@Inject
	private FakeTwitterService twitterService;

	@PostConstruct
	protected void afterInjection() {

		setMargin(true);
		setSpacing(true);

		twitterLink.setTargetName("twitterauth");
		twitterLink.setResource(new ExternalResource(twitterService.getAuthenticationUrl()));

		pinField.setInputPrompt("PIN");

		addComponent(twitterLink);
		addComponent(pinField);
		addComponent(submitButton);

		submitButton.addClickListener(this);
	}

	@Override
	public void buttonClick(ClickEvent event) {

		LoginEvent loginEvent = new LoginEvent(pinField.getValue());

		eventManager.fire(loginEvent);
	}
}
