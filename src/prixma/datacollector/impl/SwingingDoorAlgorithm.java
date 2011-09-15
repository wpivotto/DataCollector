package prixma.datacollector.impl;

import prixma.datacollector.compression.CompressionAlgorithm;
import prixma.datacollector.compression.Record;
import prixma.datacollector.filters.CompressionFilter;

public class SwingingDoorAlgorithm implements CompressionAlgorithm {
	
	private CompressionFilter filter;
	
	public SwingingDoorAlgorithm(){
		this.filter = new ChangeInSlopeFilter();
	}

	public Record submit(Record lastReceived, EventQueue queue){		
		
		if(queue.isFirstEvent())
			return lastReceived;
		
		Record result = null;
		
		for (Record candidate : queue) {
		
			if(filter.isSatisfiedBy(queue.getLastStored(), candidate, lastReceived))
				result = candidate;

		}
		
		return result;
		
	}
	

}
