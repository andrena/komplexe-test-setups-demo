package de.andrena.xpdays2017.testsetup.pojobuilder;

import java.util.Arrays;

import javax.annotation.Generated;

/**
 * The {@link VortragBuilder} is a Builder for {@link Vortrag} objects.
 * <p>
 * ATTENTION: This class has been generated. If you want to ADD HANDWRITTEN
 * CODE, please MOVE THIS FILE out of the generated-sources folder in order to
 * prevent it from being overwritten by the PojoBuilder generator!
 * </p>
 */
@Generated("PojoBuilder")
public class VortragBuilder extends AbstractVortragBuilder {

	private String[] vortragende;

	/**
	 * Factory Method to construct a VortragBuilder
	 *
	 * @return a new VortragBuilder
	 */
	public static VortragBuilder aVortrag() {
		return new VortragBuilder();
	}

	public static VortragBuilder aStandardVortrag() {
		return aVortrag() //
				.withTitel("Builder") //
				.withVortragende("Sabine", "Bastian") //
				.withVortragTyp(VortragTyp.KURZ);
	}

	/**
	 * Creates a new {@link VortragBuilder}.
	 */
	public VortragBuilder() {
	}

	public VortragBuilder withVortragende(String... vortragende) {
		this.vortragende = vortragende;
		return this;
	}

	@Override
	public Vortrag build() {
		Vortrag vortrag = super.build();
		Arrays.asList(vortragende).forEach(vortrag::addVortragender);
		return vortrag;
	}
}
