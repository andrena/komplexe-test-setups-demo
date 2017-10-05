package de.andrena.xpdays2017.testsetup.builder;

public class Ort {

	private String stadt;
	private String adresse;
	private double breitengrad;
	private double laengengrad;

	public Ort(String stadt, String adresse, double lattitude, double longitude) {
		super();
		this.stadt = stadt;
		this.adresse = adresse;
		this.breitengrad = lattitude;
		this.laengengrad = longitude;
	}

	public String getStadt() {
		return stadt;
	}

	public String getAdresse() {
		return adresse;
	}

	public double getBreitengrad() {
		return breitengrad;
	}

	public double getLaengengrad() {
		return laengengrad;
	}

}
