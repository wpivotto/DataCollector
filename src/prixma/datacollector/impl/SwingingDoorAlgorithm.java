package prixma.datacollector.impl;

import prixma.datacollector.compression.CompressionAlgorithm;
import prixma.datacollector.compression.Record;
import prixma.datacollector.filters.CompressionFilter;

public class SwingingDoorAlgorithm implements CompressionAlgorithm {
	
	private CompressionFilter filter;
	
	public SwingingDoorAlgorithm(){
		this.filter = new ChangeInSlopeFilter();
	}

	public Record submit(Record lastReceived, EventsProcessor processor){		
		
		EventQueue events = processor.getEventsFrom(lastReceived);
		
		if(events.isFirstEvent())
			return lastReceived;
		
		Record result = null;
		
		for (Record candidate : events) {
		
			if(filter.isSatisfiedBy(events.getLastStored(), candidate, lastReceived))
				result = candidate;

		}

		
		return result;
		
	}
	

}
