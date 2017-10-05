package de.andrena.xpdays2017.testsetup.pojobuilder;

import java.util.List;

@GenerateBuilder
public class Workshop extends Session {

	private boolean laptopBenoetigt = false;

	public boolean isLaptopBenoetigt() {
		return laptopBenoetigt;
	}

	public void setLaptopBenoetigt(boolean laptopBenoetigt) {
		this.laptopBenoetigt = laptopBenoetigt;
	}

	protected void setVortragende(List<String> vortragende) {
		this.vortragende = vortragende;
	}

}
