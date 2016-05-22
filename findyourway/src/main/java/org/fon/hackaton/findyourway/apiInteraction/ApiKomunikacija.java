package org.fon.hackaton.findyourway.apiInteraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiKomunikacija {

	public String sendGet(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		boolean kraj = false;
		String response = "";
		while (!kraj) {
			String s = reader.readLine();
			if (s != null) {
				response += s;
			} else {
				kraj = true;
			}
		}
		reader.close();
		return response;
	}
}
