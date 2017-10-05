package de.andrena.xpdays2017.testsetup.builder.b1.vonhand;

import java.util.Arrays;

import de.andrena.xpdays2017.testsetup.builder.Workshop;

public class WorkshopBuilder {

	private Workshop workshop = new Workshop();

	public static WorkshopBuilder aWorkshop() {
		return new WorkshopBuilder();
	}

	public static WorkshopBuilder aStandardWorkshop() {
		return aWorkshop().withTitel("Titel").withVortragende("Franziska") //
				.withLaptopBenoetigt(true);
	}

	public WorkshopBuilder withTitel(String titel) {
		workshop.setTitel(titel);
		return this;
	}

	public WorkshopBuilder withVortragende(String... namen) {
		Arrays.asList(namen).forEach(workshop::addVortragender);
		return this;
	}

	public WorkshopBuilder withLaptopBenoetigt(boolean laptopBenoetigt) {
		workshop.setLaptopBenoetigt(laptopBenoetigt);
		return this;
	}

	public Workshop build() {
		return workshop;
	}

}
