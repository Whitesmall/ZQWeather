package com.ZQWeather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 创建数据库
 * @author Administrator
 *
 */
public class ZQWeatherOpenHelper extends SQLiteOpenHelper {

	
	public ZQWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Province表建表语句
	 * */
	
	public static final String CREATE_PROVINCE = "create table Province ("
			+ "id integer primary key autoincrement, "
			+ "province_name text, "
			+ "province_code text)";
	
	/**
	 * 创建City表
	 */
	public static final String CREAT_CITY="create table City ("
			
			+"id integer primary key autoincrement,"
			+"city_name text,"
			+"city_code text,"
			+"province_id integer)";
	
	/**
	 * 创建Country表
	 */
	public static final String CREAT_COUNTRY="create table Country ("
			+"id integer primary key autoincrement,"
			+"country_name text,"
			+"country_code text,"
			+"city_id integer)";
	
	 
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_PROVINCE);
		db.execSQL(CREAT_CITY);
		db.execSQL(CREAT_COUNTRY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
