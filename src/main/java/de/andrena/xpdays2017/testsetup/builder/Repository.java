package de.andrena.xpdays2017.testsetup.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

	private Map<Konferenz, List<Session>> konferenzenMitVortraegen = new HashMap<>();
	private Map<Session, List<Bewertung>> vortraegeMitBewertungen = new HashMap<>();

	public void speichere(Konferenz konferenz) {
		konferenzenMitVortraegen.put(konferenz, new ArrayList<Session>());
	}

	public void speichere(Session session, Bewertung bewertung) {
		ladeAlleBewertungen(session).add(bewertung);
	}

	public void speichere(Konferenz konferenz, Session session) {
		ladeAlleVortraege(konferenz).add(session);
		vortraegeMitBewertungen.put(session, new ArrayList<>());
	}

	public List<Bewertung> ladeAlleBewertungen(Session session) {
		return vortraegeMitBewertungen.get(session);
	}

	public List<Session> ladeAlleVortraege(Konferenz konferenz) {
		return konferenzenMitVortraegen.get(konferenz);
	}

}
