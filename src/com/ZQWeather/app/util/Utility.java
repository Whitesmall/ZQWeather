package com.ZQWeather.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.ZQWeather.app.model.City;
import com.ZQWeather.app.model.Country;
import com.ZQWeather.app.model.Province;
import com.ZQWeather.app.model.ZQWeatherDB;

/**
 *解析和处理服务器返回的数据
 * @author Administrator
 *
 */
public class Utility {
/**
 * 解析和处理服务器返回的省级数据
 * @param zqweatherDB
 * @param response
 * @return
 */
	public synchronized static boolean handleProvincesResponse(ZQWeatherDB zqweatherDB,String response){
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces = response.split(",");
			if(allProvinces !=null &&allProvinces.length>0){
				for(String p : allProvinces){
					String[] array= p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//将解析出来的数据存储到Province表
					zqweatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	/**
	 * 将解析的和处理服务器返回的市级数据
	 */
	public static boolean handleCitiesResponse(ZQWeatherDB zqweatherDB,String response,int provinceId){
		if(!TextUtils.isEmpty(response)){
			String[] allCities = response.split(",");
			if(allCities!=null&&allCities.length>0){
				for(String c:allCities){
					String[] array =  c.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					//保存到数据库
					zqweatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 将解析和处理服务区返回的县级数据
	 */
	public static boolean handleCountriesReponse(ZQWeatherDB zqweatherDB , String response, int cityId){
		if(!TextUtils.isEmpty(response)){
			String[] allCountries = response.split(",");
		if(allCountries!=null&&allCountries.length>0){
			for(String c:allCountries){
				String[] array = c.split("\\|");
				Country country = new Country();
				country.setCountryCode(array[0]);
				country.setCountryName(array[1]);
				country.setCityId(cityId);
				//将解析的数据存储到Country表
				zqweatherDB.saveCountry(country);
			}
			return true;
		}
		}
		return false;
	}
	
	/**
	 * 将解析服务器返回JSON数据，，并将数据存储到本地
	 * 返回的数据格式
	 * {"weatherinfo":
{"city":"昆山","cityid":"101190404","temp1":"21℃","temp2":"9℃",
"weather":"多云转小雨","img1":"d1.gif","img2":"n7.gif","ptime":"11:00"}
}
	 */
	
	
	public static void handleWeahterResponse(Context context,String response){
		try{
			JSONObject jsonObject = new JSONObject(response);
			JSONObject weatherInfo = jsonObject.getJSONObject("weatherinfo");
			String cityName = weatherInfo.getString("city");
			String weatherCode= weatherInfo.getString("cityid");
			String temp1 = weatherInfo.getString("temp1");
			String temp2 = weatherInfo.getString("temp2");
			String weatherDesp = weatherInfo.getString("weather");
			String publishTime = weatherInfo.getString("ptime");
			saveWeatherInfo(context, cityName, weatherCode, temp1, temp2, weatherDesp, publishTime);
					
		}catch(JSONException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 将服务器返回的所有天气信息存储到SharedPreference文件中
	 */
	public static void saveWeatherInfo(Context context, String cityName, String weatherCode, String temp1, String temp2,
			String weatherDesp, String publishTime){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日",Locale.CHINA);
		SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
		editor.putBoolean("city_selected", true);
		editor.putString("city_name", cityName);
		editor.putString("weather_code", weatherCode);
		editor.putString("temp1",temp1);
		editor.putString("temp2", temp2);
		editor.putString("weather_desp",weatherDesp);
		editor.putString("publish_time", publishTime);
		editor.putString("current_date",sdf.format(new Date()));
		editor.commit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
