package prixma.datacollector.impl;

import java.util.Collection;
import java.util.List;

import prixma.datacollector.compression.CompressionAlgorithm;
import prixma.datacollector.compression.CompressionCallback;
import prixma.datacollector.compression.CompressionEngine;
import prixma.datacollector.compression.Record;

public class AsyncEngine implements CompressionEngine {
	
	private final DefaultEngine delegate;
	private final AsyncExecutor executor;

	public AsyncEngine() {
		this(new SwingingDoorAlgorithm());
	}
	
	public AsyncEngine(CompressionAlgorithm algorithm) {
		this.delegate = new DefaultEngine(algorithm);
		this.executor = AsyncExecutor.New();  
	}
	 
	
	public List<Record> batchProcess(Collection<Record> records) {
		return executor.submit(this.delegate, records);
	}

	public Record process(Record candidate) {
		return delegate.process(candidate);
	}
	
	public void registerCallback(CompressionCallback callback) {
		this.delegate.registerCallback(callback);
	}

	public void reset() {
		this.delegate.reset();
	}
	

}
