package de.andrena.xpdays2017.testsetup.builder.d2.java8;

import java.util.Date;

import de.andrena.xpdays2017.testsetup.builder.Konferenz;
import de.andrena.xpdays2017.testsetup.builder.Ort;

public class KonferenzBuilder extends AbstractBuilder<Konferenz, KonferenzBuilder> {

	public static KonferenzBuilder aKonferenz() {
		return new KonferenzBuilder();
	}

	public static KonferenzBuilder aStandardKonferenz() {
		return aKonferenz() //
				.withDatum(new Date()) //
				.withTitel("XPDays 2017") //
				.withOrt(new Ort("Stuttgart", "Haus der Wirtschaft", 48.779166, 9.172868));
	}

	public KonferenzBuilder withDatum(Date datum) {
		return with(Konferenz::setDatum, datum);
	}

	public KonferenzBuilder withTitel(String titel) {
		return with(Konferenz::setTitel, titel);
	}

	public KonferenzBuilder withOrt(Ort ort) {
		return with(Konferenz::setOrt, ort);
	}

}
