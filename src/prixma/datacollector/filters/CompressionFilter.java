package prixma.datacollector.filters;

import prixma.datacollector.compression.Record;


public interface CompressionFilter {

	boolean isSatisfiedBy(Record lastArchived, Record candidate, Record lastReceived);
	 
	
}
 