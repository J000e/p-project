package com.porche.addressBook.application;

import java.util.Map;

import com.porche.addressBook.display.ConsoleDisplay;
import com.porche.addressBook.display.Display;
import com.porche.addressBook.input.Input;
import com.porche.addressBook.persistence.FilePersistence;
import com.porche.addressBook.persistence.Persistence;

public class Application {
	private Display display;
	private Input input;
	private Persistence persistence;
	
	
	public static void main(String[] args) {
		new Application()
			.withDisplay(new ConsoleDisplay())
			.withPersistence(new FilePersistence())
			.withInput(new ConsoleInput())
			.launch();
	}

	private void launch() {
		validateInstanceState();
		display.showMenu();
		while (input.isNotQuit()) {
			Map<String, String> toDisplay = persistence.processInput(input.getCurrentValue());
			display.showResponse(toDisplay);
			display.showMenu();
		}
	}


	private void validateInstanceState() {
		if (display == null || persistence == null) {
			throw new IllegalStateException("You have to set up display and persistence before launch");
		}
	}

	private Application withDisplay(Display display) {
		this.display = display;
		return this;
	}
	
	private Application withInput(Input input) {
		this.input = input;
		return this;
	}
	
	private Application withPersistence(Persistence persistence) {
		this.persistence = persistence;
		return this;
	}
}
