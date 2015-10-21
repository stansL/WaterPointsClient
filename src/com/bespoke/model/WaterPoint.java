package com.bespoke.model;

import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * This class models a water point into a Java POJO
 * 
 * @author Stanslaus use of @JsonIgnoreProperties(ignoreUnknown = true) to
 *         ignore fields with no values and the non-declared fields that may
 *         cause breakage at the time of parsing the returned JSON object to
 *         this POJO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WaterPoint {
	/*
	 * Water point fields
	 */
	private String water_pay;
	private String respondent;
	private String research_asst_name;
	private String water_used_season;
	private String _bamboo_dataset_id;
	private String _deleted_at;
	private String water_point_condition;
	private String _xform_id_string;
	private String other_point_1km;
	private List<String> _attachments;
	private String communities_villages;
	private String end;
	private String animal_number;
	private String water_point_id;
	private String start;
	private String water_connected;
	private String water_manager_name;
	private String _status;
	private String enum_id_1;
	private String water_lift_mechanism;
	private String districts_divisions;
	private String _uuid;
	private String grid;
	private String date;
	private String formhub_uuid;
	private String road_available;
	private String water_functioning;
	private String _submission_time;
	private String signal;
	private String water_source_type;
	private List<String> _geolocation;
	private String water_point_image;
	private String water_point_geocode;
	private String deviceid;
	private String locations_wards;
	private String water_manager;
	private String water_developer;
	private String _id;
	private String animal_point;

	/*
	 * Getters and Setters
	 */

	public String getWater_pay() {
		return water_pay;
	}

	public void setWater_pay(String water_pay) {
		this.water_pay = water_pay;
	}

	public String getRespondent() {
		return respondent;
	}

	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}

	public String getResearch_asst_name() {
		return research_asst_name;
	}

	public void setResearch_asst_name(String research_asst_name) {
		this.research_asst_name = research_asst_name;
	}

	public String getWater_used_season() {
		return water_used_season;
	}

	public void setWater_used_season(String water_used_season) {
		this.water_used_season = water_used_season;
	}

	public String get_bamboo_dataset_id() {
		return _bamboo_dataset_id;
	}

	public void set_bamboo_dataset_id(String _bamboo_dataset_id) {
		this._bamboo_dataset_id = _bamboo_dataset_id;
	}

	public String get_deleted_at() {
		return _deleted_at;
	}

	public void set_deleted_at(String _deleted_at) {
		this._deleted_at = _deleted_at;
	}

	public String getWater_point_condition() {
		return water_point_condition;
	}

	public void setWater_point_condition(String water_point_condition) {
		this.water_point_condition = water_point_condition;
	}

	public String get_xform_id_string() {
		return _xform_id_string;
	}

	public void set_xform_id_string(String _xform_id_string) {
		this._xform_id_string = _xform_id_string;
	}

	public String getOther_point_1km() {
		return other_point_1km;
	}

	public void setOther_point_1km(String other_point_1km) {
		this.other_point_1km = other_point_1km;
	}

	public List<String> get_attachments() {
		return _attachments;
	}

	public void set_attachments(List<String> _attachments) {
		this._attachments = _attachments;
	}

	public String getCommunities_villages() {
		return communities_villages;
	}

	public void setCommunities_villages(String communities_villages) {
		this.communities_villages = communities_villages;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getAnimal_number() {
		return animal_number;
	}

	public void setAnimal_number(String animal_number) {
		this.animal_number = animal_number;
	}

	public String getWater_point_id() {
		return water_point_id;
	}

	public void setWater_point_id(String water_point_id) {
		this.water_point_id = water_point_id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getWater_connected() {
		return water_connected;
	}

	public void setWater_connected(String water_connected) {
		this.water_connected = water_connected;
	}

	public String getWater_manager_name() {
		return water_manager_name;
	}

	public void setWater_manager_name(String water_manager_name) {
		this.water_manager_name = water_manager_name;
	}

	public String get_status() {
		return _status;
	}

	public void set_status(String _status) {
		this._status = _status;
	}

	public String getEnum_id_1() {
		return enum_id_1;
	}

	public void setEnum_id_1(String enum_id_1) {
		this.enum_id_1 = enum_id_1;
	}

	public String getWater_lift_mechanism() {
		return water_lift_mechanism;
	}

	public void setWater_lift_mechanism(String water_lift_mechanism) {
		this.water_lift_mechanism = water_lift_mechanism;
	}

	public String getDistricts_divisions() {
		return districts_divisions;
	}

	public void setDistricts_divisions(String districts_divisions) {
		this.districts_divisions = districts_divisions;
	}

	public String get_uuid() {
		return _uuid;
	}

	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}

	public String getGrid() {
		return grid;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFormhub_uuid() {
		return formhub_uuid;
	}

	public void setFormhub_uuid(String formhub_uuid) {
		this.formhub_uuid = formhub_uuid;
	}

	public String getRoad_available() {
		return road_available;
	}

	public void setRoad_available(String road_available) {
		this.road_available = road_available;
	}

	public String getWater_functioning() {
		return water_functioning;
	}

	public void setWater_functioning(String water_functioning) {
		this.water_functioning = water_functioning;
	}

	public String get_submission_time() {
		return _submission_time;
	}

	public void set_submission_time(String _submission_time) {
		this._submission_time = _submission_time;
	}

	public String getSignal() {
		return signal;
	}

	public void setSignal(String signal) {
		this.signal = signal;
	}

	public String getWater_source_type() {
		return water_source_type;
	}

	public void setWater_source_type(String water_source_type) {
		this.water_source_type = water_source_type;
	}

	public List<String> get_geolocation() {
		return _geolocation;
	}

	public void set_geolocation(List<String> _geolocation) {
		this._geolocation = _geolocation;
	}

	public String getWater_point_image() {
		return water_point_image;
	}

	public void setWater_point_image(String water_point_image) {
		this.water_point_image = water_point_image;
	}

	public String getWater_point_geocode() {
		return water_point_geocode;
	}

	public void setWater_point_geocode(String water_point_geocode) {
		this.water_point_geocode = water_point_geocode;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getLocations_wards() {
		return locations_wards;
	}

	public void setLocations_wards(String locations_wards) {
		this.locations_wards = locations_wards;
	}

	public String getWater_manager() {
		return water_manager;
	}

	public void setWater_manager(String water_manager) {
		this.water_manager = water_manager;
	}

	public String getWater_developer() {
		return water_developer;
	}

	public void setWater_developer(String water_developer) {
		this.water_developer = water_developer;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getAnimal_point() {
		return animal_point;
	}

	public void setAnimal_point(String animal_point) {
		this.animal_point = animal_point;
	}

}
