package com.liu.lab28;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class JSONMain {

	public static void main(String[] args) {

		String url = "http://forecast.weather.gov/MapClick.php?lat=42.335722&lon=-83.049944&FcstType=json";
		
		URL urlObj;
		
		
		try{
			urlObj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			
			con.setRequestMethod("GET");
			
			int responseCode = con.getResponseCode();
			
			
			if(responseCode == 200){
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while((inputLine=in.readLine()) !=null){
					response.append(inputLine);
					//System.out.println(inputLine);
				}
				in.close();
				//Parse JSON
				//System.out.println(response);
				
				Gson gson = new Gson();
				NOAA noaa = gson.fromJson(response.toString(), NOAA.class);
				
				System.out.println(noaa.getCurrentobservation().getName());
				System.out.println(noaa.getData().getText().get(0));
			}else{
				
			}
		}catch(MalformedURLException e){
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
