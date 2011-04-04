package prixma.datacollector.impl;

import prixma.datacollector.compression.Record;
import prixma.datacollector.filters.CompressionFilter;

/**
 * Filtra os registros proximos a reta de compressao, dentro da zona morta permitida
 */
public class ChangeInSlopeFilter implements CompressionFilter {

	@Override
	public boolean isSatisfiedBy(Record lastArchived, Record candidate, Record lastReceived) {
		
		CompressionLine line = new CompressionLine(lastArchived, lastReceived);
		
		return !line.interceptedBy(candidate);
		
	}

}
