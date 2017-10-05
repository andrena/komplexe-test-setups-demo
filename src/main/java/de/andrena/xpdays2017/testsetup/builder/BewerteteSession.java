package de.andrena.xpdays2017.testsetup.builder;

import java.util.List;

public class BewerteteSession {

	private Session session;
	private List<Bewertung> bewertungen;
	private Note gesamtNote;

	public BewerteteSession(Session session, List<Bewertung> bewertungen) {
		this.session = session;
		this.bewertungen = bewertungen;
	}

	public Note getGesamtNote() {
		return gesamtNote;
	}

	public Session getSession() {
		return session;
	}

	public List<Bewertung> getBewertungen() {
		return bewertungen;
	}

	public void setGesamtNote(Note gesamtNote) {
		this.gesamtNote = gesamtNote;
	}

}
