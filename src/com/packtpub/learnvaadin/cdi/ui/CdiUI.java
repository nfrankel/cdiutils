package com.packtpub.learnvaadin.cdi.ui;

import javax.inject.Inject;

import org.vaadin.virkki.cdiutils.application.UIContext.UIScoped;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@UIScoped
public class CdiUI extends UI {

	@Inject
	private LoginScreen loginScreen;

	@Override
	protected void init(VaadinRequest request) {

		setContent(loginScreen);
	}
}