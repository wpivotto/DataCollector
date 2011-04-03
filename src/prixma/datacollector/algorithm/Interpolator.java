package prixma.datacollector.algorithm;

import prixma.datacollector.compression.Record;

public class Interpolator {
	
	private final Slope slope;
	private final Record point;
	
	public Interpolator (Record point1, Record point2) {

		this.point = point1;
		this.slope = new Slope(point1, point2);

	}
	
	
	/**
	 * y = mx - mx0 + y0
	 * Encontrando o valor de y pela equacao da reta
	 */
	public Double getValue(Record record){
		return (slope.getValue() * record.getTimestamp()) - (slope.getValue() * point.getTimestamp()) + point.getValue();
	}

}
