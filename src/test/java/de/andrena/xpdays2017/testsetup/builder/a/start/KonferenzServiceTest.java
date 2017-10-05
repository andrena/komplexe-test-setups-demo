package de.andrena.xpdays2017.testsetup.builder.a.start;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.andrena.xpdays2017.testsetup.builder.BewerteteSession;
import de.andrena.xpdays2017.testsetup.builder.Bewertung;
import de.andrena.xpdays2017.testsetup.builder.Konferenz;
import de.andrena.xpdays2017.testsetup.builder.KonferenzService;
import de.andrena.xpdays2017.testsetup.builder.Note;
import de.andrena.xpdays2017.testsetup.builder.Ort;
import de.andrena.xpdays2017.testsetup.builder.Rangliste;
import de.andrena.xpdays2017.testsetup.builder.Vortrag;
import de.andrena.xpdays2017.testsetup.builder.VortragTyp;
import de.andrena.xpdays2017.testsetup.builder.Workshop;

public class KonferenzServiceTest {

	private KonferenzService konferenzService = new KonferenzService();

	@Test
	public void testRangliste() {
		// Erstelle Konferenz + Speichern
		Konferenz konferenz = new Konferenz();
		konferenz.setDatum(new Date());
		konferenz.setTitel("XPDays 2017");
		konferenz.setOrt(new Ort("Stuttgart", "Haus der Wirtschaft", 48.779166, 9.172868));
		konferenzService.speichere(konferenz);

		// Erstelle Workshop + Speichern
		Workshop workshop = new Workshop();
		workshop.setTitel("Object Calisthenics");
		workshop.addVortragender("Franziska");
		workshop.setLaptopBenoetigt(true);
		konferenzService.speichere(konferenz, workshop);

		// Erstelle Vortrag + Speichern
		Vortrag vortrag = new Vortrag();
		vortrag.setTitel("Builder");
		vortrag.addVortragender("Sabine");
		vortrag.addVortragender("Bastian");
		vortrag.setVortragTyp(VortragTyp.KURZ);
		konferenzService.speichere(konferenz, vortrag);

		// Erstelle Bewertungen für Workshop + Speichern
		Bewertung bewertungWorkshop1 = new Bewertung(Note.BEFRIEDIGEND, Note.BEFRIEDIGEND, Note.SEHR_GUT, Note.GUT);
		konferenzService.speichere(workshop, bewertungWorkshop1);

		Bewertung bewertungWorkshop2 = new Bewertung(Note.GUT, Note.BEFRIEDIGEND, Note.SEHR_GUT, Note.GUT);
		konferenzService.speichere(workshop, bewertungWorkshop2);

		// Erstelle Bewertung für Vortrag + Speichern
		Bewertung bewertungVortrag = new Bewertung(Note.BEFRIEDIGEND, Note.GUT, Note.SEHR_GUT, Note.GUT);
		konferenzService.speichere(vortrag, bewertungVortrag);

		// Frage Vortrags-Ranking ab
		Rangliste rangliste = konferenzService.getVortragsRangliste(konferenz);

		List<BewerteteSession> eintraege = rangliste.getSortierteEintraege();
		assertThat(eintraege, hasSize(2));
		assertBewerteteSession(eintraege.get(0), "Builder", 2, "2.00");
		assertBewerteteSession(eintraege.get(1), "Object Calisthenics", 1, "2.13");
	}

	private void assertBewerteteSession(BewerteteSession bewerteteSession, String expectedTitel,
			int expectedVortragendeCount, String expectedNote) {
		assertThat(bewerteteSession.getGesamtNote().getWert(), is(new BigDecimal(expectedNote)));
		assertThat(bewerteteSession.getSession().getTitel(), is(expectedTitel));
		assertThat(bewerteteSession.getSession().getAnzahlVortragende(), is(expectedVortragendeCount));
	}

}
