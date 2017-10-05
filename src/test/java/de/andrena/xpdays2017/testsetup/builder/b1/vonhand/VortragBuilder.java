package de.andrena.xpdays2017.testsetup.builder.b1.vonhand;

import java.util.Arrays;

import de.andrena.xpdays2017.testsetup.builder.Vortrag;
import de.andrena.xpdays2017.testsetup.builder.VortragTyp;

public class VortragBuilder {

	private Vortrag vortrag = new Vortrag();

	public static VortragBuilder aVortrag() {
		return new VortragBuilder();
	}

	public static VortragBuilder aStandardVortrag() {
		return aVortrag().withTitel("Titel").addVortragende("Bastian") //
				.withVortragTyp(VortragTyp.KURZ);
	}

	public VortragBuilder withTitel(String titel) {
		vortrag.setTitel(titel);
		return this;
	}

	public VortragBuilder addVortragende(String... namen) {
		Arrays.asList(namen).forEach(vortrag::addVortragender);
		return this;
	}

	public VortragBuilder withVortragTyp(VortragTyp vortragTyp) {
		vortrag.setVortragTyp(vortragTyp);
		return this;
	}

	public Vortrag build() {
		return vortrag;
	}

}
