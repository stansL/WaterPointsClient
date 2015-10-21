package com.bespoke.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bespoke.util.ValueComparator;

/**
 * This class models the overall structure of the water point infrastructure
 * This models the infrastructure resources by holding the overall number of
 * water points that are functional , non-functional and un-categorised**
 * 
 * @author Stanslaus
 *
 */
public class WaterPointsData {

	// holds the number of functional water points in general (not taking into
	// account where they are located)
	private int numberFunctional = 0;
	/**
	 * This field is a {@link Map} that holds the key-value pair of water
	 * points, the key being the name of the village/community and the value is @see
	 * {@link CommunityWaterPointsData} which is a model of a community set of
	 * water points
	 */
	private Map<String, CommunityWaterPointsData> communityWaterPointsMap;

	/*
	 * List containing all the water points retrieved from the waterfeed web
	 * service(JSON)
	 */
	private List<WaterPoint> waterPoints;

	public List<WaterPoint> getWaterPoints() {
		return waterPoints;
	}

	public void setWaterPoints(List<WaterPoint> waterPoints) {
		this.waterPoints = waterPoints;
	}

	/**
	 * Gets the number of listed water points that are functional. The
	 * functional water points are the ones with the property
	 * "water_functioning" = "yes"
	 * 
	 * @return Number of water points with the water_functioning property = to
	 *         "yes"
	 * 
	 */
	public int getNumberFunctional() {
		// loop over all the water point objects and figure out if the property
		// water_functioning has a value of "yes"
		for (WaterPoint point : waterPoints) {
			if (point.getWater_functioning().equalsIgnoreCase("yes")) {
				numberFunctional++;
			}
		}
		return numberFunctional;
	}

	public void setNumberFunctional(int numberFunctional) {
		this.numberFunctional = numberFunctional;
	}

	public Map<String, CommunityWaterPointsData> getWaterpointsCount() {

		return computeWaterpointsCount(this.waterPoints);
	}

	public void setWaterpointsCount(
			Map<String, CommunityWaterPointsData> waterpointsCount) {
		this.communityWaterPointsMap = waterpointsCount;
	}

	/**
	 * This method takes a list of water points and deduces the location of the
	 * water point it also works out the total count of water points within a
	 * given community/village
	 * 
	 * @param waterPoints
	 *            the {@link List} of all the water points returned from the
	 *            Water points feed
	 * @return a {@link Map} containing the key-value pairs of all the
	 *         village/community name as the key and a count of the water points
	 *         within that location as an integer.
	 */
	private Map<String, CommunityWaterPointsData> computeWaterpointsCount(
			List<WaterPoint> waterPoints) {
		communityWaterPointsMap = new HashMap<String, CommunityWaterPointsData>();

		for (WaterPoint point : waterPoints) {
			// get the name of the Community/Village to be used as the key in
			// map
			String key = point.getCommunities_villages();
			/*
			 * get the indication on whether the water point is functional or
			 * not this is found on the water_functioning property in the
			 * retrieved JSON
			 */
			String functString = point.getWater_functioning();

			// Check if we already have the village/community for the water
			// point in the map so that we update it
			// in by incrementing the functional/non-functional/other water
			// points number
			if (communityWaterPointsMap.containsKey(key)) {
				CommunityWaterPointsData meta = communityWaterPointsMap
						.get(key);
				// figure out if the water point is functional,non-functional or
				// other
				if (functString.equalsIgnoreCase("yes")) {
					meta.setNumberFunctional(meta.getNumberFunctional() + 1);

				} else if (functString.equalsIgnoreCase("no")) {
					meta.setNumberNonFunctional(meta.getNumberNonFunctional() + 1);

				} else {
					meta.setNumberOther(meta.getNumberOther() + 1);

				}

				// add the overall count
				meta.setWaterpointCount(meta.getWaterpointCount() + 1);

				communityWaterPointsMap.put(key, meta);
			} else {
				// otherwise, the water point is in a village/community that we
				// have not encountered before,
				// thus the need to load it for future updates
				CommunityWaterPointsData meta = new CommunityWaterPointsData();
				meta.setCommunityName(key);
				if (functString.equalsIgnoreCase("yes")) {
					meta.setNumberFunctional(1);

				} else if (functString.equalsIgnoreCase("no")) {
					meta.setNumberNonFunctional(1);

				} else {
					meta.setNumberOther(1);

				}
				// add the overall count
				meta.setWaterpointCount(meta.getWaterpointCount() + 1);

				communityWaterPointsMap.put(key, meta);
			}
		}
		return communityWaterPointsMap;
	}

	/**
	 * This method formats and displays the summary of water points within a
	 * village/community
	 * 
	 * @param someMap
	 *            The map containing the key value pairs of the village names
	 *            and their associated details @see
	 *            {@link CommunityWaterPointsData}
	 * 
	 */
	public void displayCommunityWaterpoints(
			Map<String, CommunityWaterPointsData> someMap) {
		System.out.printf("%-16s   %3s %3s %3s %3s\n", "Vilage", "Fun", "Non",
				"Tot", "PBr");

		for (Map.Entry<String, CommunityWaterPointsData> entry : someMap
				.entrySet()) {

			System.out.printf("%-16s : %3s %3s %3s %3s\n", entry.getKey(),
					entry.getValue().getNumberFunctional(), entry.getValue()
							.getNumberNonFunctional(), entry.getValue()
							.getWaterpointCount(), entry.getValue()
							.getPercentageBroken());
		}
	}

	/**
	 * Method to display the community rank by the percentage of broken water
	 * points. This method purely relies on the percentage and as such does not
	 * do any further ordering in the case where communities/villages have the
	 * same percentage in terms of broken water points
	 * 
	 * @param someMap
	 */
	public void displayCommunityRank(
			Map<String, CommunityWaterPointsData> someMap) {
		Map<String, Double> localMap = new HashMap<String, Double>();
		for (Map.Entry<String, CommunityWaterPointsData> entry : someMap
				.entrySet()) {
			localMap.put(entry.getKey(), entry.getValue().getPercentageBroken());
		}
		int rank = 1;
		Map<String, Double> p = ValueComparator.sortByValue(localMap);
		for (Map.Entry<String, Double> entry : p.entrySet()) {
			System.out.printf("%2d. %-15s %s\n", rank++, entry.getKey(),
					entry.getValue());
		}

	}

}
