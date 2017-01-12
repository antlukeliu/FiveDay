package com.liu.lab28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
	
		model.addAttribute("city", null);
		
		return "home";
	}
	
	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public String weather(HttpServletRequest request, Model model) {
		
		String url; 
		url = CaseSwitch.getURL(request.getParameter("city"));
		
		
		URL urlObj;

		try {
			urlObj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();

			if (responseCode == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);

				}
				in.close();

				Gson gson = new Gson();
				NOAA noaa = gson.fromJson(response.toString(), NOAA.class);

				model.addAttribute("city", noaa);

			} else {

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return "home";
	}


}
