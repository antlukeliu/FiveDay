package com.liu.lab28;
import java.util.List;

public class NOAA {
	private Data data;
	private Weather currentobservation;
	private Time time;
	
	public NOAA(){
		
	}

	public Weather getCurrentobservation() {
		return currentobservation;
	}

	public void setCurrentobservation(Weather currentobservation) {
		this.currentobservation = currentobservation;
	}

	/**
	 * @return the data
	 */
	public Data getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Data data) {
		this.data = data;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}


}