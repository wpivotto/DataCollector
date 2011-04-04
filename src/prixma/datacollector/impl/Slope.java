package prixma.datacollector.impl;

import prixma.datacollector.compression.Record;

public class Slope {
	
	private final Double value;

	public Slope(Record point1, Record point2) {
		this.value = (point2.getValue() - point1.getValue()) / (point2.getTimestamp() - point1.getTimestamp()); 
	}
   
	public Double getValue() {
		return value;
	}
	
	
}
