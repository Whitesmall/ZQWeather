package com.ZQWeather.app.model;

public class Province {
	
	private int id;
	private String provincename;
	private String provincecode;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getProvinceName(){
		return provincename;
	}
	
	public void setProvinceName(String provincename){
		this.provincename = provincename;
	}
	
	public String getProvinceCode(){
		return provincecode;
	}
	
	public void setProvinceCode(String provincecode){
		this.provincecode=provincecode;
	}
	
}
