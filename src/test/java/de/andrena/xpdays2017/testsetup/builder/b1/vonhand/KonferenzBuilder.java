package de.andrena.xpdays2017.testsetup.builder.b1.vonhand;

import java.util.Date;

import de.andrena.xpdays2017.testsetup.builder.Konferenz;
import de.andrena.xpdays2017.testsetup.builder.Ort;

public class KonferenzBuilder {

	private Konferenz konferenz = new Konferenz();

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
		konferenz.setDatum(datum);
		return this;
	}

	public KonferenzBuilder withTitel(String titel) {
		konferenz.setTitel(titel);
		return this;
	}

	public KonferenzBuilder withOrt(Ort ort) {
		konferenz.setOrt(ort);
		return this;
	}

	public Konferenz build() {
		return konferenz;
	}

}
