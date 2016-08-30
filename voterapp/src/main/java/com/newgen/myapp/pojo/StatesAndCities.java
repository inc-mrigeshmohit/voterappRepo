package com.newgen.myapp.pojo;

import java.util.List;
import java.util.Map;

public class StatesAndCities {
	private int cityId;
	private int stateId;
	private String cityName;
	private String latitude;
	private String longitude;
	private String stateName;
	
	//TODO
	private List<String> stateList;
	private List<String> ciltyList;
	
	//TODO
	private Map<StatesAndCities, List<String>> cityMap;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "\nStatesAndCities [cityId=" + cityId + ", stateId=" + stateId
				+ ", cityName=" + cityName + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", stateName=" + stateName + "]";
	}

	

}
