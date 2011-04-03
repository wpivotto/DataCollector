package prixma.datacollector.filters;

import prixma.datacollector.compression.Deadband;
import prixma.datacollector.compression.Record;


public class CompressionDeviationFilter implements CompressionFilter {

	@Override
	public boolean isSatisfiedBy(Record lastArchived, Record candidate, Record lastReceived) {
		
		Deadband deadband = lastArchived.getDeadband();
		
		return candidate.isOutside(deadband);
	}

}
