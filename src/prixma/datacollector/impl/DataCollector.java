package prixma.datacollector.impl;

import java.util.Collection;
import java.util.List;

import prixma.datacollector.compression.CompressionCallback;
import prixma.datacollector.compression.CompressionEngine;
import prixma.datacollector.compression.CompressionLogger;
import prixma.datacollector.compression.CompressionReport;
import prixma.datacollector.compression.Record;


public class DataCollector {
	
	private final CompressionEngine engine;
	private CompressionReport report;
	
	public DataCollector() {
		this(new DefaultEngine());
	}
	
	public DataCollector(CompressionEngine engine) {
		this.engine = engine;
		this.report = new CompressionReport();
	}

	public List<Record> submit(Collection<Record> candidates){
		return engine.batchProcess(candidates);
	}
	
	public Record submit(Record candidate){
		return engine.process(candidate);
	}
	
	public void reset(){
		engine.reset();
	}
	
	public void enableLog(){
		this.engine.registerCallback(new CompressionLogger());
		this.engine.registerCallback(this.report);
	}
	
	public void register(CompressionCallback callback){
		this.engine.registerCallback(callback);
	}
	
	public void generateReport(){
		if(report != null)
			report.print();
	}

}
