package de.andrena.xpdays2017.testsetup.builder.d2.java8;

import de.andrena.xpdays2017.testsetup.builder.Session;

public abstract class SessionBuilder<ENTITY extends Session, BUILDER extends SessionBuilder<ENTITY, BUILDER>>
		extends AbstractBuilder<ENTITY, BUILDER> {

	public BUILDER withTitel(String titel) {
		return with(Session::setTitel, titel);
	}

	public BUILDER addVortragender(String name) {
		return with(Session::addVortragender, name);
	}

}
