package com.bespoke.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.bespoke.exceptions.BadWaterFeedURLException;
import com.bespoke.exceptions.WaterFeedException;
import com.bespoke.model.WaterPoint;
import com.bespoke.model.WaterPointsData;

/**
 * This class comes in as the "interface" to the external data provider/web
 * service/JSON file that provides the
 * 
 * @see WaterPoint details. It pings the data source (data provider/web
 *      service/JSON file) via the provided URL and returns the JSON string
 *      which is then parsed to a list of @see {@code WaterPointsData}
 * @author Stanslaus
 *
 */
public class WaterPointClient {

	// separated the functionality of the calculate("http://...") as provided in
	// the assignemnt document into
	// calculate("JSON String") and getFeedData("http://...") for modularity and
	// to separate the two functionalities into
	// different modules/methods

	/**
	 * The processor method to convert the received JSON string into a list of
	 * java {@code WaterPointsData} object that would then allow for the
	 * processing of the retrieved data
	 * 
	 * @param feedData
	 *            - String representation of the JSON data that represents the
	 *            water points information
	 * @return {@link WaterPointsData} object that models the representation of
	 *         the set of villages/communities and their associated water points
	 *         and their details
	 * @throws WaterFeedException
	 *             if there is an error processing or reading the JSON
	 */

	public WaterPointsData calculate(String feedData) throws WaterFeedException {
		ObjectMapper mapper = new ObjectMapper();
		WaterPoint[] points;
		WaterPointsData pointsData = null;
		try {
			pointsData = new WaterPointsData();
			points = mapper.readValue(feedData, WaterPoint[].class);
			pointsData.setWaterPoints(Arrays.asList(points));

		} catch (IOException e) {
			throw new WaterFeedException(e.getMessage());
		}
		return pointsData;
	}

	/**
	 * The data pinging method that 'pings' the data source/web service/JSON
	 * provider to get the JSON representation of the water points data.
	 * 
	 * @param urlString
	 *            - The URL of the web service/ data provider that is to return
	 *            the JSON representation of the water points data
	 * @return returns the string representation of the pulled JSON data
	 * @throws BadWaterFeedURLException
	 *             if a wrong URL is provided
	 * @throws WaterFeedException
	 *             if data cannot be read from the provided url
	 */
	public String getFeedData(String urlString)
			throws BadWaterFeedURLException, WaterFeedException {
		String output = null;
		try {
			// forn a URL object to help us access the web service
			URL url = new URL(urlString);
			// Use HTTPConnection to open a connection to hte URL
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			// set the request method to HTTP GET
			connection.setRequestMethod("GET");
			// specify the kind of data to process from the connection
			connection.setRequestProperty("Accept", "application/json");

			// throw an exception if there is any error depicted by the returned
			// error codes(440/500...etc)
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ connection.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));
			output = readBuffer(br);
			// close the connection
			connection.disconnect();

		} catch (MalformedURLException e) {
			throw new BadWaterFeedURLException(e.getMessage());
		} catch (IOException e) {
			throw new WaterFeedException(e.getMessage());
		}

		return output;
	}

	/**
	 * Utility method for reading data from a {@link BufferedReader} and
	 * returning the read content as a {@link String}
	 * 
	 * @param buffIn
	 *            - The {@link Reader} object to read from
	 * @return - A string representation of all the content read from the
	 *         provided reader
	 * @throws IOException
	 *             if the reader cannot be accessed at any point for content
	 *             reading
	 */
	public String readBuffer(BufferedReader buffIn) throws IOException {
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = buffIn.readLine()) != null) {
			builder.append(line);
		}
		return builder.toString();
	}
	
	
	//other way to read in the stuff
//	public WaterPointsData calculate(String url){
//		Client client=ClientBuilder.newClient();
//		WebTarget target = client.target(url);
//		WaterPointsData response = target.path("").request(MediaType.APPLICATION_JSON).get(WaterPointsData.class);
//		return response;
//		
//	}
	
	
	
	

}
