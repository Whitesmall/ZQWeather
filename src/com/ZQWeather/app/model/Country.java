package com.ZQWeather.app.model;

public class Country {
	public int id;
	public String countryname;
	public String countrycode;
	public int cityid;
	
	public int getId(){
		return id;
	}
	
	public void  setId(int id){
		this.id = id;
	}
	
	public String getCountryName(){
		return countryname;
	}
	
	public void setCountryName(String countryname){
		this.countryname = countryname;
	}
	
	public String getCountryCode(){
		return countrycode;
	}
	
	public void setCountryCode(String countrycode){
		this.countrycode = countrycode;
	}
	
	public int getCityId(){
		return cityid;
	}
	
	public void setCityId(int cityid){
		this.cityid = cityid;
	}
}
