package org.fon.hackaton.findyourway.domen;

import java.util.LinkedList;

public class Skola {
	LinkedList<PodrucjeRada> smerovi;
	String tipSkole; // tehnicka, gimnazija, strucna
	Koordinate koordinate;
	String sajt;

	public LinkedList<PodrucjeRada> getSmerovi() {
		return smerovi;
	}

	public void setSmerovi(LinkedList<PodrucjeRada> smerovi) {
		this.smerovi = smerovi;
	}

	public String getTipSkole() {
		return tipSkole;
	}

	public void setTipSkole(String tipSkole) {
		this.tipSkole = tipSkole;
	}

	public Koordinate getKoordinate() {
		return koordinate;
	}

	public void setKoordinate(Koordinate koordinate) {
		this.koordinate = koordinate;
	}

	public String getSajt() {
		return sajt;
	}

	public void setSajt(String sajt) {
		this.sajt = sajt;
	}

	public Skola(LinkedList<PodrucjeRada> smerovi, String tipSkole, Koordinate koordinate, String sajt) {
		this.smerovi = smerovi;
		this.tipSkole = tipSkole;
		this.koordinate = koordinate;
		this.sajt = sajt;
	}

	public Skola() {
	}

}
