package prixma.datacollector.compression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompressionReport implements CompressionCallback {
	
	private static final Logger Log = LoggerFactory.getLogger(CompressionReport.class);
	
	private long stored, events, discarded;

	public Long getEventCount(){
		return events;
	}
	
	public Long getDiscardedCount(){
		return discarded;
	}
	
	public Long getStoredCount(){
		return stored;
	}
	
	public double getCompressionRatio(){
		return  ((double)stored / events);
	}
	
	public double getCompression(){
		return (1 - getCompressionRatio()) * 100; 
	}


	public void approved(Record record) {
		stored++;
	}


	public void rejected(Record record) {
		discarded++;
	}


	public void received(Record record) {
		events++;
	}

	public void print() {
		Log.info("---------- COMPRESSION REPORT ----------");
		Log.info("Events: " + getEventCount());
		Log.info("Stored: " + getStoredCount());
		Log.info("Compression Ratio: " + getCompression() + "%");
		
	}
	
}
