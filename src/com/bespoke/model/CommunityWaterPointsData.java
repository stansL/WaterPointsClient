package com.bespoke.model;

/**
 * This class models the structure of a community/village and details about
 * water points found in it, taking a minimal set of details about a particular
 * village's points such as the village name, the number of functional,
 * non-functional and other water points. It also has a field for the percentage
 * of broken(non-functional) water points within the modeled village/community
 * 
 * @author Stanslaus
 *
 */
public class CommunityWaterPointsData implements
		Comparable<CommunityWaterPointsData> {
	// name of the village/community to be modeled
	private String communityName;
	// total count of all the water points within the modeled community
	private int waterpointCount;
	// count of the functional water points(property water_functioning = yes)
	private int numberFunctional;
	// count of the non-functional water points(property water_functioning = no)
	private int numberNonFunctional;
	// count of the other water points(property water_functioning = neither yes
	// nor no)
	private int numberOther;
	// number of broken water points as a percentage on the total water points
	private double percentageBroken;

	/*
	 * Getters and Setters
	 */

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public int getWaterpointCount() {
		return waterpointCount;
	}

	public void setWaterpointCount(int waterpointCount) {
		this.waterpointCount = waterpointCount;
	}

	public int getNumberFunctional() {
		return numberFunctional;
	}

	public void setNumberFunctional(int numberFunctional) {
		this.numberFunctional = numberFunctional;
	}

	public int getNumberNonFunctional() {
		return numberNonFunctional;
	}

	public void setNumberNonFunctional(int numberNonFunctional) {
		this.numberNonFunctional = numberNonFunctional;
	}

	public int getNumberOther() {
		return numberOther;
	}

	public void setNumberOther(int numberOther) {
		this.numberOther = numberOther;
	}

	public double getPercentageBroken() {
		return (numberNonFunctional * 1.0) / waterpointCount;
	}

	public void setPercentageBroken(double percentageBroken) {
		this.percentageBroken = percentageBroken;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[communityName=" + getCommunityName() + ", waterpointCount="
				+ getWaterpointCount() + ", numberNonFunctional="
				+ getNumberNonFunctional() + ", percentageBroken="
				+ getPercentageBroken() + "]";
	}

	@Override
	public int compareTo(CommunityWaterPointsData o) {
		if (!(o instanceof CommunityWaterPointsData))
			throw new ClassCastException(
					"A CommunityWaterPointsData object expected.");

		int perCompare = Double.compare(percentageBroken,
				o.getPercentageBroken());
		return perCompare;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(percentageBroken);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CommunityWaterPointsData)) {
			return false;
		}
		CommunityWaterPointsData other = (CommunityWaterPointsData) obj;
		if (Double.doubleToLongBits(percentageBroken) != Double
				.doubleToLongBits(other.percentageBroken)) {
			return false;
		}
		return true;
	}

}
