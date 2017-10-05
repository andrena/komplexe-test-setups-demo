package de.andrena.xpdays2017.testsetup.builder.b2.abstractbuilder;

import java.util.Arrays;

import de.andrena.xpdays2017.testsetup.builder.Session;

@SuppressWarnings("unchecked")
public abstract class SessionBuilder<ENTITY extends Session, BUILDER extends SessionBuilder<ENTITY, BUILDER>>
		extends AbstractBuilder<ENTITY> {

	public BUILDER withTitel(String titel) {
		entity.setTitel(titel);
		return (BUILDER) this;
	}

	public BUILDER withVortragende(String... namen) {
		Arrays.asList(namen).forEach(entity::addVortragender);
		return (BUILDER) this;
	}

}
