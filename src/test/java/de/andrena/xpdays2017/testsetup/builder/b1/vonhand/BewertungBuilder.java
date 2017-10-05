package de.andrena.xpdays2017.testsetup.builder.b1.vonhand;

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

	public static BewertungBuilder aGuteBewertung() {
		return aBewertung().withAkustischVerstaendlich(Note.GUT).withRoterFaden(Note.GUT) //
				.withSessionStil(Note.GUT).withThemaVerstaendlich(Note.GUT);
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
