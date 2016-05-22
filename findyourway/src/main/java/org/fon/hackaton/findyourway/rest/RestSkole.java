package org.fon.hackaton.findyourway.rest;

import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fon.hackaton.findyourway.domen.Skola;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/skole")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class RestSkole {
	private LinkedList<Skola> skole;
	Gson gson;

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
	/*
	@GET
	@Path("/{}")
	*/
}
