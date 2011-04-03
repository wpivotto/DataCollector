package prixma.datacollector.compression;

import prixma.datacollector.algorithm.EventsProcessor;



public interface CompressionAlgorithm {
	
	Record submit(Record lastReceived, EventsProcessor processor);
	
}
