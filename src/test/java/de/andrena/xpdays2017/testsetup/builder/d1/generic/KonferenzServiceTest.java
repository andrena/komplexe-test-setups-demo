package de.andrena.xpdays2017.testsetup.builder.d1.generic;

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
		Konferenz konferenz = GenericBuilder.of(Konferenz::new) //
				.with(Konferenz::setDatum, new Date()) //
				.with(Konferenz::setTitel, "XPDays 2017")
				.with(Konferenz::setOrt, new Ort("Stuttgart", "Haus der Wirtschaft", 48.779166, 9.172868)) //
				.build();
		konferenzService.speichere(konferenz);

		// Erstelle Workshop + Speichern
		Workshop workshop = GenericBuilder.of(Workshop::new) //
				.with(Workshop::setTitel, "Object Calisthenics") //
				.with(Workshop::addVortragender, "Franziska") //
				.with(Workshop::setLaptopBenoetigt, true).build();
		konferenzService.speichere(konferenz, workshop);

		// Erstelle Vortrag + Speichern
		Vortrag vortrag = GenericBuilder.of(Vortrag::new) //
				.with(Vortrag::setTitel, "Builder") //
				.with(Vortrag::addVortragender, "Sabine") //
				.with(Vortrag::addVortragender, "Bastian") //
				.with(Vortrag::setVortragTyp, VortragTyp.KURZ) //
				.build();
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
