package prixma.datacollector.impl;

import prixma.datacollector.compression.Record;

public class CompressionLine {

	private final Interpolator interpolator;


	public CompressionLine (Record point1, Record point2) {

		this.interpolator = new Interpolator(point1, point2);

	}
  
	public boolean interceptedBy(Record record) {
		return distanceTo(record) <= record.getCompressionDeviation();
	}	
	
	/**
	 * Encontra a proximidade do registro em relacao a reta de compressao
	 */
	private Double distanceTo(Record record){
		return Math.abs(record.getValue() - interpolator.getValue(record));
	}

	



}
