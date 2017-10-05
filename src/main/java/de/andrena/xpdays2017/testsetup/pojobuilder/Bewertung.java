package de.andrena.xpdays2017.testsetup.pojobuilder;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

public class Bewertung {

	private final Note akustischVerstaendlich;
	private final Note themaVerstaendlich;
	private final Note roterFaden;
	private final Note sessionStil;

	@GenerateBuilder
	public Bewertung(Note akustischVerstaendlich, Note themaVerstaendlich, Note roterFaden, Note sessionStil) {
		this.akustischVerstaendlich = akustischVerstaendlich;
		this.themaVerstaendlich = themaVerstaendlich;
		this.roterFaden = roterFaden;
		this.sessionStil = sessionStil;
	}

	public Note getSessionStil() {
		return sessionStil;
	}

	public Note getAkustischVerstaendlich() {
		return akustischVerstaendlich;
	}

	public Note getRoterFaden() {
		return roterFaden;
	}

	public Note getThemaVerstaendlich() {
		return themaVerstaendlich;
	}

	public Optional<Note> berechneDurchschnitt() {
		return berechneDurchschnitt(akustischVerstaendlich, themaVerstaendlich, roterFaden, sessionStil);
	}

	private Optional<Note> berechneDurchschnitt(Note... noten) {
		return valideNoten(noten) //
				.map(Note::getWert) //
				.reduce((a, b) -> a.add(b)) //
				.map(summe -> summe.divide(anzahlValiderNoten(noten))) //
				.map(Note::new);
	}

	private BigDecimal anzahlValiderNoten(Note... noten) {
		return new BigDecimal(valideNoten(noten).count());
	}

	private Stream<Note> valideNoten(Note... noten) {
		return asList(noten).stream().filter(note -> note != null);
	}

}
