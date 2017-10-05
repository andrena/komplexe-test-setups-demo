package de.andrena.xpdays2017.testsetup.builder.d2.java8;

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
import de.andrena.xpdays2017.testsetup.builder.VortragTyp;
import de.andrena.xpdays2017.testsetup.builder.Workshop;

public class KonferenzServiceTest {

	private KonferenzService konferenzService = new KonferenzService();

	@Test
	public void testRangliste() {
		// Erstelle Konferenz + Speichern
		Konferenz konferenz = KonferenzBuilder.aStandardKonferenz().build(Konferenz::new);
		konferenzService.speichere(konferenz);

		// Erstelle Workshop + Speichern
		Workshop workshop = WorkshopBuilder.aWorkshop() //
				.withTitel("Object Calisthenics") //
				.addVortragender("Franziska") //
				.withLaptopBenoetigt(true) //
				.build(Workshop::new);
		konferenzService.speichere(konferenz, workshop);

		// Erstelle Vortrag + Speichern
		Vortrag vortrag = VortragBuilder.aVortrag() //
				.withTitel("Builder") //
				.addVortragender("Sabine") //
				.addVortragender("Bastian") //
				.withVortragTyp(VortragTyp.KURZ).build(Vortrag::new);
		konferenzService.speichere(konferenz, vortrag);

		// Erstelle Bewertungen für Workshop + Speichern
		Bewertung bewertungWorkshop1 = BewertungBuilder.aBewertung() //
				.withAkustischVerstaendlich(Note.BEFRIEDIGEND) //
				.withThemaVerstaendlich(Note.BEFRIEDIGEND) //
				.withRoterFaden(Note.SEHR_GUT) //
				.withSessionStil(Note.GUT).build();
		konferenzService.speichere(workshop, bewertungWorkshop1);

		Bewertung bewertungWorkshop2 = BewertungBuilder.aBewertung() //
				.withAkustischVerstaendlich(Note.GUT) //
				.withThemaVerstaendlich(Note.BEFRIEDIGEND) //
				.withRoterFaden(Note.SEHR_GUT) //
				.withSessionStil(Note.GUT).build();
		konferenzService.speichere(workshop, bewertungWorkshop2);

		// Erstelle Bewertung für Vortrag + Speichern
		Bewertung bewertungVortrag = BewertungBuilder.aBewertung() //
				.withAkustischVerstaendlich(Note.BEFRIEDIGEND) //
				.withThemaVerstaendlich(Note.GUT) //
				.withRoterFaden(Note.SEHR_GUT) //
				.withSessionStil(Note.GUT).build();
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
