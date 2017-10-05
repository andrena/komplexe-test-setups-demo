package de.andrena.xpdays2017.testsetup.builder.b2.abstractbuilder;

import de.andrena.xpdays2017.testsetup.builder.Workshop;

public class WorkshopBuilder extends SessionBuilder<Workshop, WorkshopBuilder> {

	public static WorkshopBuilder aWorkshop() {
		return new WorkshopBuilder();
	}

	public WorkshopBuilder withLaptopBenoetigt(boolean laptopBenoetigt) {
		entity.setLaptopBenoetigt(laptopBenoetigt);
		return this;
	}

}
