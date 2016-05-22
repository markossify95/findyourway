package org.fon.hackaton.findyourway.domen;

import java.util.LinkedList;

public class Skola {
	private int skola_id;
	private String naziv;
	private String adresa;
	private LinkedList<PodrucjeRada> smerovi;
	private Koordinate koordinate;
	private String sajt;
	
	public Skola(int skola_id, String naziv, String adresa, LinkedList<PodrucjeRada> smerovi,
			Koordinate koordinate, String sajt) {
		super();
		this.skola_id = skola_id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.smerovi = smerovi;
		this.koordinate = koordinate;
		this.sajt = sajt;
	}

	public int getSkola_id() {
		return skola_id;
	}

	public void setSkola_id(int skola_id) {
		this.skola_id = skola_id;
	}
	
	public Skola(String naziv, String adresa, LinkedList<PodrucjeRada> smerovi,  Koordinate koordinate,
			String sajt) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.smerovi = smerovi;
		this.koordinate = koordinate;
		this.sajt = sajt;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public LinkedList<PodrucjeRada> getSmerovi() {
		return smerovi;
	}

	public void setSmerovi(LinkedList<PodrucjeRada> smerovi) {
		this.smerovi = smerovi;
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

	public Skola() {
	}

}
