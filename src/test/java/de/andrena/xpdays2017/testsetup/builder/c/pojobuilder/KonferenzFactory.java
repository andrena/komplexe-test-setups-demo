package de.andrena.xpdays2017.testsetup.builder.c.pojobuilder;

import java.util.Date;

import de.andrena.xpdays2017.testsetup.pojobuilder.KonferenzBuilder;
import de.andrena.xpdays2017.testsetup.pojobuilder.OrtBuilder;

public class KonferenzFactory {

	public static KonferenzBuilder aStandardKonferenzBuilder() {
		return KonferenzBuilder.aKonferenz() //
				.withDatum(new Date()) //
				.withTitel("XPDays 2017") //
				.withOrt(OrtBuilder.aOrt().withStadt("Stuttgart").withAdresse("Haus der Wirtschaft")
						.withLattitude(48.779166).withLongitude(9.172868).build());
	}

}
