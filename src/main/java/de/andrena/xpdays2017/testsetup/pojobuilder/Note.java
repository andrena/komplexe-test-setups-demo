package de.andrena.xpdays2017.testsetup.pojobuilder;

import java.math.BigDecimal;

public class Note implements Comparable<Note> {

	public static final Note AUSREICHEND = new Note(4);
	public static final Note BEFRIEDIGEND = new Note(3);
	public static final Note GUT = new Note(2);
	public static final Note SEHR_GUT = new Note(1);
	public static final Note UNBEKANNT = new Note(0);

	private BigDecimal wert;

	public Note(int wert) {
		this(new BigDecimal(wert));
	}

	public Note(BigDecimal wert) {
		this.wert = wert;
	}

	public BigDecimal getWert() {
		return wert;
	}

	@Override
	public int compareTo(Note other) {
		return this.wert.compareTo(other.wert);
	}

}
