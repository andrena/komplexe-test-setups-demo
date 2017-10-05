package de.andrena.xpdays2017.testsetup.builder;

import java.util.List;

public class KonferenzService {

	private Repository repository = new Repository();
	private GesamtNoteBerechner gesamtNoteBerechner = new GesamtNoteBerechner();

	public void speichere(Konferenz konferenz) {
		repository.speichere(konferenz);
	}

	public void speichere(Konferenz konferenz, Session session) {
		repository.speichere(konferenz, session);
	}

	public void speichere(Session session, Bewertung bewertung) {
		repository.speichere(session, bewertung);
	}

	public Rangliste getVortragsRangliste(Konferenz konferenz) {
		Rangliste rangliste = new Rangliste();
		List<Session> vortraege = repository.ladeAlleVortraege(konferenz);
		for (Session session : vortraege) {
			rangliste.add(berechneGesamtBewertung(session));
		}
		return rangliste;
	}

	private BewerteteSession berechneGesamtBewertung(Session session) {
		List<Bewertung> bewertungen = repository.ladeAlleBewertungen(session);
		return gesamtNoteBerechner.berechne(session, bewertungen);
	}
}
