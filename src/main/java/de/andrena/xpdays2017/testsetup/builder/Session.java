package de.andrena.xpdays2017.testsetup.builder;

import java.util.ArrayList;
import java.util.List;

public abstract class Session {

	private String titel;
	private List<String> vortragende = new ArrayList<>();

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getTitel() {
		return titel;
	}

	public void addVortragender(String vortragender) {
		vortragende.add(vortragender);
	}

	public int getAnzahlVortragende() {
		return vortragende.size();
	}

}
