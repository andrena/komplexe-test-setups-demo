package de.andrena.xpdays2017.testsetup.builder.d2.java8;

import de.andrena.xpdays2017.testsetup.builder.Workshop;

public class WorkshopBuilder extends SessionBuilder<Workshop, WorkshopBuilder> {

	public static WorkshopBuilder aWorkshop() {
		return new WorkshopBuilder();
	}

	public WorkshopBuilder withLaptopBenoetigt(boolean laptopBenoetigt) {
		return with(Workshop::setLaptopBenoetigt, laptopBenoetigt);
	}

}
