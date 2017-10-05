package de.andrena.xpdays2017.testsetup.builder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class GesamtNoteBerechner {

	public BewerteteSession berechne(Session session, List<Bewertung> bewertungen) {
		BewerteteSession bewerteteSession = new BewerteteSession(session, bewertungen);
		bewerteteSession.setGesamtNote(berechneDurchschnitt(bewertungen));
		return bewerteteSession;
	}

	private Note berechneDurchschnitt(List<Bewertung> bewertungen) {
		return notenWerteValiderBewertungen(bewertungen).reduce((a, b) -> a.add(b)) //
				.map((summe) -> summe.divide(anzahlValiderBewertungen(bewertungen), 2, RoundingMode.HALF_UP)) //
				.map(Note::new).orElse(Note.UNBEKANNT);
	}

	private BigDecimal anzahlValiderBewertungen(List<Bewertung> bewertungen) {
		return new BigDecimal(notenWerteValiderBewertungen(bewertungen).count());
	}

	private Stream<BigDecimal> notenWerteValiderBewertungen(List<Bewertung> bewertungen) {
		return bewertungen.stream() //
				.map(bewertung -> bewertung.berechneDurchschnitt()) //
				.filter(Optional::isPresent).map(Optional::get) //
				.map(Note::getWert);
	}

}
