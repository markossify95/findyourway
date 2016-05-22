package org.fon.hackaton.findyourway.model;

import java.awt.SecondaryLoop;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.fon.hackaton.findyourway.apiInteraction.ApiKomunikacija;
import org.fon.hackaton.findyourway.domen.Koordinate;
import org.fon.hackaton.findyourway.domen.PodrucjeRada;
import org.fon.hackaton.findyourway.domen.Skola;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class SkolaModel {
	// tabela skolske lokacije
	private static final String urlSkole = "http://opendata.mpn.gov.rs/get.php?dataset=maticne_izdvojena&lang=sr&term=json";
	// tabela podaci o srednjim skolama
	private static final String urlPodaciOSrednjim = "http://opendata.mpn.gov.rs/get.php?dataset=ss_skole15&lang=sr&term=json";
	// tabela sifranik podrucja rada u srednjim skolama
	private static final String urlPodrucja = "http://opendata.mpn.gov.rs/get.php?dataset=ss_podrucja_rada&lang=sr&term=json";
	// id za srednju skolu
	// http://opendata.mpn.gov.rs/get.php?dataset=vrste&lang=sr&term=human
	private static final int tipSkole = 2;

	private List<Skola> skole;

	public SkolaModel() {
		skole = new LinkedList<>();
	}

	public List<Skola> vratiSkole() throws IOException {
		ApiKomunikacija api = new ApiKomunikacija();
		String result = api.sendGet(urlSkole);
		Gson gson = new GsonBuilder().create();

		// pravimo json niz svih skola
		JsonArray skoleJson = gson.fromJson(result, JsonArray.class);
		LinkedList<Skola> skole = new LinkedList<>();
		for (int i = 0; i < skoleJson.size(); i++) {
			JsonObject sJson = (JsonObject) skoleJson.get(i);

			int tip = sJson.get("vrsta_id").getAsInt();
			// ako je srednja skola pravimo nov objekat
			if (tip == tipSkole) {
				Skola skola = new Skola();
				int id = sJson.get("skola_id").getAsInt();
				skola.setSkola_id(sJson.get("skola_id").getAsInt());
				skola.setNaziv(sJson.get("naziv_skole").getAsString());
				skola.setAdresa(sJson.get("adresa").getAsString());
				skola.setSajt(sJson.get("www").getAsString());
				LinkedList<PodrucjeRada> pod = vratiPodrucjaRada(id);
				skola.setSmerovi(pod);
				String lokacija = sJson.get("gps").getAsString();				
				System.out.println("sranje");
				String[] koord;
				if (lokacija.contains(", ")) {
					koord = lokacija.split(", ");
					if ((koord[0].split("\\.").length) > 2 || (koord[1].split("\\.").length) > 2) {
						//System.out.println("ubagovani: "+ lokacija);
						continue;
					}
					if (!(zadnjiBroj(koord[0]) && zadnjiBroj(koord[1]))) {
						continue;
					}
					
				}else if (lokacija.contains(" ")) {
					koord = lokacija.split(" ");
					if ((koord[0].split("\\.").length) > 2 || (koord[1].split("\\.").length) > 2) {
						//System.out.println("ubagovani: "+ lokacija);
						continue;
					}
					if (!(zadnjiBroj(koord[0]) && zadnjiBroj(koord[1]))) {
						continue;
					}
					
				}else if(lokacija.contains(",")){
					koord = lokacija.split(",");
					if ((koord[0].split("\\.").length) > 2 || (koord[1].split("\\.").length) > 2) {
						//System.out.println("ubagovani: "+ lokacija);
						continue;
					}
					if (!(zadnjiBroj(koord[0]) && zadnjiBroj(koord[1]))) {
						continue;
					}
									
				}else{
					continue;
				}
				
				//System.out.println("Koord1= " + koord[0] +" Koord2= "+koord[1]); //zajebava oko splitovanja ne znam koji kurac
				double X = Double.parseDouble(koord[0]);//javlja gresku-neki degen nije stavio zarez na json formatu izgleda pa ga ne splituje nego ostane ceo broj zbog razmaka
				double Y = Double.parseDouble(koord[1]);
				Koordinate k = new Koordinate(X, Y);
				skola.setKoordinate(k);
				skole.add(skola);
			}
		}

		return skole;
	}

	// Podrucja rada moraju da se vade iz posebne tabele
	private LinkedList<PodrucjeRada> vratiPodrucjaRada(int idSkole) throws IOException {
		ApiKomunikacija api = new ApiKomunikacija();
		String result = api.sendGet(urlPodaciOSrednjim);
		Gson gson = new GsonBuilder().create();
		JsonArray podrucjaJson = gson.fromJson(result, JsonArray.class);
		LinkedList<PodrucjeRada> podrucja = new LinkedList<>();
		for (int i = 0; i < podrucjaJson.size(); i++) {
			JsonObject pJson = (JsonObject) podrucjaJson.get(i);
			int id = pJson.get("skola_id").getAsInt();
			if (idSkole == id) {
				String p = pJson.get("podrucje_rada").getAsString();
				String[] pd = p.split(",");
				for (int j = 0; j < pd.length; j++) {
					int ajDi = Integer.parseInt(pd[j]);
					String naziv = vratiNazivPodrucja(ajDi);
					PodrucjeRada pr = new PodrucjeRada();
					pr.setSmer_id(ajDi);
					pr.setNaziv(naziv);
					podrucja.add(pr);
				}
			}
		}

		return podrucja;
	}

	// Opet naziv podrucja rada se vraca preko id-a
	private String vratiNazivPodrucja(int idPodrucja) throws IOException {
		ApiKomunikacija api = new ApiKomunikacija();
		String result = api.sendGet(urlPodrucja);
		Gson gson = new GsonBuilder().create();
		JsonArray podrucjaJson = gson.fromJson(result, JsonArray.class);
		for (int i = 0; i < podrucjaJson.size(); i++) {
			JsonObject pJson = (JsonObject) podrucjaJson.get(i);
			int id = pJson.get("podrucje_rada").getAsInt();
			if (idPodrucja == id) {
				return pJson.get("naziv_podrucje_rada").getAsString();
			}
		}
		return "";
	}
	
	private boolean zadnjiBroj(String s){
		String c = s.substring(s.length()-1);
		if (c.equals("0") || c.equals("1") || c.equals("2") || c.equals("3") || c.equals("4") || c.equals("5") || c.equals("6") || c.equals("7") || c.equals("8") || c.equals("8") ) {
			return true;
		}
		return false;
	}
}
