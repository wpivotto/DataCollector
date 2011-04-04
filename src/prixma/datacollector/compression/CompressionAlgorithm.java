package prixma.datacollector.compression;

import prixma.datacollector.impl.EventsProcessor;



public interface CompressionAlgorithm {
	
	Record submit(Record lastReceived, EventsProcessor processor);
	
}
