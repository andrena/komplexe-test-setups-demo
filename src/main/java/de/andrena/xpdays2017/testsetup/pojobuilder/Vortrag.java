package de.andrena.xpdays2017.testsetup.pojobuilder;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder(withFactoryMethod = "a*", withCopyMethod = true, withGenerationGap = true)
public class Vortrag extends Session {

	private VortragTyp vortragTyp;

	public VortragTyp getVortragTyp() {
		return vortragTyp;
	}

	public void setVortragTyp(VortragTyp vortragTyp) {
		this.vortragTyp = vortragTyp;
	}

}
