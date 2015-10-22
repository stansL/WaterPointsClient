# WaterPointsClient
Software Engineering Pract


This project serves as the solution to the practical posted at: https://docs.google.com/document/d/1QbnaZBmjg2NAQTpdczRAojuAbhFdVI1ZHoWlG6ZCJ4A/edit#

It structures the functionality around the use of water points, tracking the number of water points per community, the number of functional water points and the rank of each community based on the percentage of water points that are broken

The model revolves aroung the following:

1. A hosted web service that does a simple job of supplying the JSON string containing the details on water points - This is fairly fixed at the moment and is hosted at http://waterpoints-greid.rhcloud.com/api/waterfeed
2. POJO to represent a water points
3. A community water point data structure modeling the name of the community and the data about the water points in that community (e.g functional, non-functional...etc)
4. Top level structure having :
	a. The total number of functional waterpoints across all villages
	b. A key value pair linking a community to its model structure representing water points
	c. utility methods to compute the number of water points per community and the percentage ranking. This is computed as it varies given the json data received from the feed


