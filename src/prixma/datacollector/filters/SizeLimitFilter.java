package prixma.datacollector.filters;

import prixma.datacollector.compression.Record;
import prixma.datacollector.impl.EventQueue;
import prixma.datacollector.impl.EventsProcessor;


public class SizeLimitFilter implements CompressionFilter {
	
	private final EventsProcessor processor;
	private final int limit;
	
	public SizeLimitFilter(EventsProcessor processor, int limit){
		this.processor = processor;
		this.limit = limit;
	}

	@Override
	public boolean isSatisfiedBy(Record lastArchived, Record candidate, Record lastReceived) {
		
		EventQueue queue = processor.getEventsFrom(lastReceived);
		return queue.size() > limit;
	
	}

}
