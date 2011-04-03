package prixma.datacollector.filters;

import prixma.datacollector.compression.Record;


public class TimeBetweenRecordsFilter implements CompressionFilter {

	@Override
	public boolean isSatisfiedBy(Record lastArchived, Record candidate, Record lastReceived) {
		
		long max = candidate.getCompressionMaximumTime(); //filtro para sinal sem variacao
		
		long min = candidate.getCompressionMinimumTime(); //filtro para sinal ruidoso
		
		long time = timeBetweenRecords(lastArchived, lastReceived);
		
		return time > min && time > max;
	
	}
	
	private long timeBetweenRecords(Record previous, Record last){
		return (last.getTimestamp() - previous.getTimestamp());
	}


	

}
