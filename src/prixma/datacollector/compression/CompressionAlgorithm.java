package prixma.datacollector.compression;

import prixma.datacollector.impl.EventQueue;



public interface CompressionAlgorithm {
	
	Record submit(Record lastReceived, EventQueue queue);
	
}
