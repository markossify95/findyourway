package org.fon.hackaton.findyourway.domen;

public class PodrucjeRada {
	private int podrucje_id;
	private String naziv;
	private int brojUcenika;
	private int potrebnoPoena;
	private int trajanje; //koliko godina

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public int getSmer_id() {
		return podrucje_id;
	}

	public void setSmer_id(int smer_id) {
		this.podrucje_id = smer_id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getBrojUcenika() {
		return brojUcenika;
	}

	public void setBrojUcenika(int brojUcenika) {
		this.brojUcenika = brojUcenika;
	}

	public int getPotrebnoPoena() {
		return potrebnoPoena;
	}

	public void setPotrebnoPoena(int potrebnoPoena) {
		this.potrebnoPoena = potrebnoPoena;
	}


	public PodrucjeRada(int smer_id, String naziv, int brojUcenika, int potrebnoPoena, int trajanje) {
		super();
		this.podrucje_id = smer_id;
		this.naziv = naziv;
		this.brojUcenika = brojUcenika;
		this.potrebnoPoena = potrebnoPoena;
		this.trajanje = trajanje;
	}

	public PodrucjeRada() {
	}
}
