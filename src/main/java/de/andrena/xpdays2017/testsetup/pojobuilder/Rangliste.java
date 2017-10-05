package de.andrena.xpdays2017.testsetup.pojobuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Rangliste {

	private List<BewerteteSession> rangliste = new ArrayList<BewerteteSession>();

	public void add(BewerteteSession bewerteteSession) {
		rangliste.add(bewerteteSession);
	}

	public List<BewerteteSession> getSortierteEintraege() {
		return rangliste.stream() //
				.sorted(Comparator.comparing(BewerteteSession::getGesamtNote)) //
				.collect(Collectors.toList());
	}
}
