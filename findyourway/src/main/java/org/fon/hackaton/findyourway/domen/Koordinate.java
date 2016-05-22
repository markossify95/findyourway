package org.fon.hackaton.findyourway.domen;

public class Koordinate {
	private double koordX;
	private double koordY;

	public double getKoordX() {
		return koordX;
	}

	public void setKoordX(double koordX) {
		this.koordX = koordX;
	}

	public double getKoordY() {
		return koordY;
	}

	public void setKoordY(double koordY) {
		this.koordY = koordY;
	}

	public Koordinate(double koordX, double koordY) {
		super();
		this.koordX = koordX;
		this.koordY = koordY;
	}

	public Koordinate() {
	}
}
