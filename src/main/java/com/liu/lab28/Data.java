package com.liu.lab28;
import java.util.List;

/**
 * 
 */

/**
 * @author Luke Liu
 *
 */
public class Data {
	private List<Integer> temperature;
	private List<String> text;
	/**
	 * @return the text
	 */
	public List<String> getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(List<String> text) {
		this.text = text;
	}

	/**
	 * @return the temperature
	 */
	public List<Integer> getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(List<Integer> temperature) {
		this.temperature = temperature;
	}

	
}
