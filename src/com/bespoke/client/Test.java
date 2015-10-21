package com.bespoke.client;

import java.util.Map;
import java.util.logging.Logger;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.bespoke.exceptions.BadWaterFeedURLException;
import com.bespoke.exceptions.WaterFeedException;
import com.bespoke.model.CommunityWaterPointsData;
import com.bespoke.model.WaterPointsData;

public class Test {

	private final static Logger LOGGER = Logger.getLogger(Test.class.getName());
	public static void main(String[] args) {
		 
		Test test=new Test();

		WaterPointClient client = new WaterPointClient();
		String url = "http://localhost:8082/waterpoint/api/waterfeed";
		
		try {
			String data = client
					.getFeedData(url);
			JSONArray array = new JSONArray(data);
			System.out.println("Number of water points: " + array.length());
			WaterPointsData wpd = client.calculate(data);
			System.out.printf("Number of Functional Water Points : %s",
					wpd.getNumberFunctional());
			
			// print out the water points
			Map<String, CommunityWaterPointsData> points = wpd.getWaterpointsCount();
			System.out.println("\nNumber of water points per Community:\n");
			wpd.displayCommunityWaterpoints(points);
			
			System.out.println("\nRank of water points per Community by percentage of broken points :\n");
			System.out.printf("%2s. %-15s %s\n", "No", "Community", "Perc broken");
			wpd.displayCommunityRank(points);

			
		} catch (JSONException e) {
			LOGGER.severe("Error Processing the JSON String "+e.getMessage());
		} catch (BadWaterFeedURLException e) {
			LOGGER.severe("Error Processing the provided URL "+e.getMessage());
		} catch (WaterFeedException e) {
			LOGGER.severe("Error reading or processing the JSON String "+e.getMessage());
		}

	}

	

}
