package de.andrena.xpdays2017.testsetup.builder.b2.abstractbuilder;

import de.andrena.xpdays2017.testsetup.builder.Vortrag;
import de.andrena.xpdays2017.testsetup.builder.VortragTyp;

public class VortragBuilder extends SessionBuilder<Vortrag, VortragBuilder> {

	public static VortragBuilder aVortrag() {
		return new VortragBuilder();
	}

	public VortragBuilder withVortragTyp(VortragTyp vortragTyp) {
		entity.setVortragTyp(vortragTyp);
		return this;
	}

}
