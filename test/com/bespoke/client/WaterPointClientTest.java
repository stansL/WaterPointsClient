package com.bespoke.client;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.junit.Test;

import com.bespoke.exceptions.BadWaterFeedURLException;
import com.bespoke.exceptions.WaterFeedException;
import com.bespoke.model.WaterPointsData;

public class WaterPointClientTest {

	String url = "http://localhost:8082/waterpoint/api/waterfeed";
	WaterPointClient client = new WaterPointClient();

	@Test
	public void testCalculate() {

		WaterPointsData wpd = null;
		try {
			String data = client.getFeedData(url);
			assertNotNull(data);
			JSONArray array = new JSONArray(data);
			assertNotNull(array);
			System.out.println("Number of water points: " + array.length());
			wpd = client.calculate(data);
		} catch (WaterFeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadWaterFeedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(wpd);

	}

	@Test
	public void testGetFeedData() {

		String data = null;
		String jsonData = null;
		try {
			data = client.getFeedData(url);
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream("water-points.json");
			jsonData = IOUtils.toString(is, "UTF-8");
		} catch (BadWaterFeedURLException | WaterFeedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(data);
		assertEquals("JSON strings should be the same", data, jsonData);
	}

	@Test
	public void testReadBuffer() {
		// forn a URL object to help us access the web service
		URL urlTest;
		String testResult=null;
		// Use HTTPConnection to open a connection to hte URL
		HttpURLConnection connection;
		try {
			urlTest = new URL(url);
			connection = (HttpURLConnection) urlTest.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));
			assertNotNull(br);
			testResult = client.readBuffer(br);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(testResult);

	}
}
