package de.andrena.xpdays2017.testsetup.builder.d2.java8;

import de.andrena.xpdays2017.testsetup.builder.Vortrag;
import de.andrena.xpdays2017.testsetup.builder.VortragTyp;

public class VortragBuilder extends SessionBuilder<Vortrag, VortragBuilder> {

	public static VortragBuilder aVortrag() {
		return new VortragBuilder();
	}

	public VortragBuilder withVortragTyp(VortragTyp vortragTyp) {
		return with(Vortrag::setVortragTyp, vortragTyp);
	}

}
