package prixma.datacollector.impl;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

import prixma.datacollector.compression.CompressionEngine;
import prixma.datacollector.compression.Record;

public class CompressionTask implements Callable<List<Record>> {
	
	private final CompressionEngine engine;
	private final Collection<Record> records;
	
	public CompressionTask(CompressionEngine engine, Collection<Record> records) {
		this.engine = engine;
		this.records = records;
	}


	@Override
	public List<Record> call() throws Exception {
		return engine.batchProcess(records);
	}
	
}