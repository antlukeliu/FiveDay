package com.liu.lab28;

import java.util.Arrays;
import java.util.List;

public class CaseSwitch {
	private static final List<String> cities = Arrays.asList ("las vegas", "seattle", "austin", "detroit");
	
	public static String getURL(String city){
		int index = cities.indexOf(city);
		
		switch(index){
			
		case 0: return "http://forecast.weather.gov/MapClick.php?lat=36.160407&lon=-115.146170&FcstType=json";
		case 1: return "http://forecast.weather.gov/MapClick.php?lat=47.602264&lon=-122.305015&FcstType=json";
		case 2: return "http://forecast.weather.gov/MapClick.php?lat=30.292048&lon=-97.730096&FcstType=json";
		case 3: return "http://forecast.weather.gov/MapClick.php?lat=42.335722&lon=-83.049944&FcstType=json";
		default: return null;
		}
	}
}
