package de.andrena.xpdays2017.testsetup.builder;

public class Workshop extends Session {

	private boolean laptopBenoetigt = false;

	public boolean isLaptopBenoetigt() {
		return laptopBenoetigt;
	}

	public void setLaptopBenoetigt(boolean laptopBenoetigt) {
		this.laptopBenoetigt = laptopBenoetigt;
	}

}
