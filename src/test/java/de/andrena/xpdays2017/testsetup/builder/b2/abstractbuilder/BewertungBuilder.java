package de.andrena.xpdays2017.testsetup.builder.b2.abstractbuilder;

import de.andrena.xpdays2017.testsetup.builder.Bewertung;
import de.andrena.xpdays2017.testsetup.builder.Note;

public class BewertungBuilder {

	private Note akustischVerstaendlich;
	private Note themaVerstaendlich;
	private Note roterFaden;
	private Note sessionStil;

	public static BewertungBuilder aBewertung() {
		return new BewertungBuilder();
	}

	public BewertungBuilder withAkustischVerstaendlich(Note note) {
		akustischVerstaendlich = note;
		return this;
	}

	public BewertungBuilder withThemaVerstaendlich(Note note) {
		themaVerstaendlich = note;
		return this;
	}

	public BewertungBuilder withRoterFaden(Note note) {
		roterFaden = note;
		return this;
	}

	public BewertungBuilder withSessionStil(Note note) {
		sessionStil = note;
		return this;
	}

	public Bewertung build() {
		return new Bewertung(akustischVerstaendlich, themaVerstaendlich, roterFaden, sessionStil);
	}

}
