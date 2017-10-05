package de.andrena.xpdays2017.testsetup.builder.b1.vonhand;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import de.andrena.xpdays2017.testsetup.builder.BewerteteSession;
import de.andrena.xpdays2017.testsetup.builder.Bewertung;
import de.andrena.xpdays2017.testsetup.builder.Konferenz;
import de.andrena.xpdays2017.testsetup.builder.KonferenzService;
import de.andrena.xpdays2017.testsetup.builder.Note;
import de.andrena.xpdays2017.testsetup.builder.Rangliste;
import de.andrena.xpdays2017.testsetup.builder.Vortrag;
import de.andrena.xpdays2017.testsetup.builder.Workshop;

public class KonferenzServiceTestKompakt {

	private KonferenzService konferenzService = new KonferenzService();

	@Test
	public void testRangliste() {
		// Erstelle Konferenz + Speichern
		Konferenz konferenz = KonferenzBuilder.aStandardKonferenz().build();
		konferenzService.speichere(konferenz);

		// Erstelle Workshop + Speichern
		Workshop workshop = WorkshopBuilder.aStandardWorkshop() //
				.withTitel("Object Calisthenics").build();
		konferenzService.speichere(konferenz, workshop);

		// Erstelle Vortrag + Speichern
		Vortrag vortrag = VortragBuilder.aStandardVortrag() //
				.withTitel("Builder").addVortragende("Sabine").build();
		konferenzService.speichere(konferenz, vortrag);

		// Erstelle Bewertungen für Workshop + Speichern
		Bewertung bewertungWorkshop1 = BewertungBuilder.aGuteBewertung().build();
		konferenzService.speichere(workshop, bewertungWorkshop1);

		Bewertung bewertungWorkshop2 = BewertungBuilder.aGuteBewertung() //
				.withRoterFaden(Note.SEHR_GUT).build();
		konferenzService.speichere(workshop, bewertungWorkshop2);

		// Erstelle Bewertung für Vortrag + Speichern
		Bewertung bewertungVortrag = BewertungBuilder.aGuteBewertung() //
				.withThemaVerstaendlich(Note.SEHR_GUT).build();
		konferenzService.speichere(vortrag, bewertungVortrag);

		// Frage Vortrags-Ranking ab
		Rangliste rangliste = konferenzService.getVortragsRangliste(konferenz);

		List<BewerteteSession> eintraege = rangliste.getSortierteEintraege();
		assertThat(eintraege, hasSize(2));
		assertBewerteteSession(eintraege.get(0), "Builder", 2, "1.75");
		assertBewerteteSession(eintraege.get(1), "Object Calisthenics", 1, "1.88");
	}

	private void assertBewerteteSession(BewerteteSession bewerteteSession, String expectedTitel,
			int expectedVortragendeCount, String expectedNote) {
		assertThat(bewerteteSession.getGesamtNote().getWert(), is(new BigDecimal(expectedNote)));
		assertThat(bewerteteSession.getSession().getTitel(), is(expectedTitel));
		assertThat(bewerteteSession.getSession().getAnzahlVortragende(), is(expectedVortragendeCount));
	}

}
