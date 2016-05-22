package org.fon.hackaton.findyourway.rest;

import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fon.hackaton.findyourway.domen.PodrucjeRada;
import org.fon.hackaton.findyourway.domen.Skola;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Path("/skole")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class RestSkole {
	private LinkedList<Skola> skole;
	private LinkedList<PodrucjeRada> listaSvihPodrucja;
	Gson gson;

	public RestSkole(LinkedList<Skola> skole, LinkedList<PodrucjeRada> listaSvihPodrucja, Gson gson) {
		this.skole = skole;
		this.listaSvihPodrucja = listaSvihPodrucja;
		this.gson = gson;
	}

	public LinkedList<PodrucjeRada> getListaSvihPodrucja() {
		return listaSvihPodrucja;
	}

	public void setListaSvihPodrucja(LinkedList<PodrucjeRada> listaSvihPodrucja) {
		this.listaSvihPodrucja = listaSvihPodrucja;
	}

	public LinkedList<Skola> getSkole() {
		return skole;
	}

	public void setSkole(LinkedList<Skola> skole) {
		this.skole = skole;
	}

	public RestSkole(LinkedList<Skola> skole) {
		this.skole = skole;
		gson = new GsonBuilder().create();
	}
	
	@GET 
	@Path("/pretragasmer")
	public JsonArray vratiSkolePoSmeru(@PathParam("pretragasmer") String smer){
		JsonArray jaraj = new JsonArray();
		for (Skola s : skole) {
			for (PodrucjeRada p : s.getSmerovi()) {
				if (p.getNaziv().equals(smer)) {
					JsonObject sk = new JsonObject();
					sk.addProperty("naziv", s.getNaziv());
					sk.addProperty("adresa", s.getAdresa());
					sk.addProperty("koordX", s.getKoordinate().getKoordX());
					sk.addProperty("koordY", s.getKoordinate().getKoordY());
					sk.addProperty("sajt", s.getSajt());
					jaraj.add(sk);
				}
			}
		}
		return jaraj;
	} 

	@GET 
	@Path("/pretraganaziv")
	public JsonObject vratiSkoluPoNazivu(@PathParam("pretraganaziv") String naziv){
		JsonObject nova = new JsonObject();
		for(Skola s : skole){
			if(s.getNaziv().equals(naziv)){
				nova.addProperty("naziv", s.getNaziv());
				nova.addProperty("adresa", s.getAdresa());
				nova.addProperty("koordX", s.getKoordinate().getKoordX());
				nova.addProperty("koordY", s.getKoordinate().getKoordY());
				nova.addProperty("sajt", s.getSajt());
				break;
			}
		}
		return nova;
	} 
	
	@GET
	@Path("/{kriterijum}")
	public JsonArray vratiSkoleSaSmerom(@PathParam("kriterijum") JsonObject podrucje) {

		int podrucje_id = podrucje.get("podrucje_rada").getAsInt();
		JsonArray jaraj = new JsonArray();
		for (Skola s : skole) {
			for (PodrucjeRada p : s.getSmerovi()) {
				if (p.getSmer_id() == podrucje_id) {
					JsonObject sk = new JsonObject();
					sk.addProperty("naziv", s.getNaziv());
					sk.addProperty("adresa", s.getAdresa());
					sk.addProperty("koordX", s.getKoordinate().getKoordX());
					sk.addProperty("koordY", s.getKoordinate().getKoordY());
					sk.addProperty("sajt", s.getSajt());
					jaraj.add(sk);
				}
			}
		}
		return jaraj;
	}

}
