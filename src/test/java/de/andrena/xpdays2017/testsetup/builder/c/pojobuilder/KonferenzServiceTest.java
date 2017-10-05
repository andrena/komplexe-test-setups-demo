package de.andrena.xpdays2017.testsetup.builder.c.pojobuilder;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.andrena.xpdays2017.testsetup.pojobuilder.BewerteteSession;
import de.andrena.xpdays2017.testsetup.pojobuilder.Bewertung;
import de.andrena.xpdays2017.testsetup.pojobuilder.BewertungBuilder;
import de.andrena.xpdays2017.testsetup.pojobuilder.Konferenz;
import de.andrena.xpdays2017.testsetup.pojobuilder.KonferenzService;
import de.andrena.xpdays2017.testsetup.pojobuilder.Note;
import de.andrena.xpdays2017.testsetup.pojobuilder.Rangliste;
import de.andrena.xpdays2017.testsetup.pojobuilder.Vortrag;
import de.andrena.xpdays2017.testsetup.pojobuilder.VortragBuilder;
import de.andrena.xpdays2017.testsetup.pojobuilder.Workshop;
import de.andrena.xpdays2017.testsetup.pojobuilder.WorkshopBuilder;

public class KonferenzServiceTest {

	private KonferenzService konferenzService = new KonferenzService();

	@Test
	public void testRangliste() {
		// Erstelle Konferenz + Speichern
		Konferenz konferenz = KonferenzFactory.aStandardKonferenzBuilder().build();
		konferenzService.speichere(konferenz);

		// Erstelle Workshop + Speichern
		Workshop workshop = WorkshopBuilder.aWorkshop() //
				.withTitel("Object Calisthenics") //
				.withVortragende(Arrays.asList("Franziska")) //
				.withLaptopBenoetigt(true) //
				.build();
		konferenzService.speichere(konferenz, workshop);

		// Erstelle Vortrag + Speichern
		Vortrag vortrag = VortragBuilder.aStandardVortrag().build();
		konferenzService.speichere(konferenz, vortrag);

		// Erstelle Bewertungen f�r Workshop + Speichern
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

		// Erstelle Bewertung f�r Vortrag + Speichern
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
