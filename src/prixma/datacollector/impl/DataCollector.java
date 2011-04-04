package prixma.datacollector.impl;

import java.util.Collection;
import java.util.List;

import prixma.datacollector.compression.CompressionEngine;
import prixma.datacollector.compression.CompressionLogger;
import prixma.datacollector.compression.CompressionReport;
import prixma.datacollector.compression.Record;


public class DataCollector {
	
	private final CompressionEngine engine;
	private CompressionReport report;
	
	public DataCollector() {
		this(new AsyncEngine());
	}
	
	public DataCollector(CompressionEngine engine) {
		this.engine = engine;
		this.report = new CompressionReport();
	}

	public List<Record> submit(Collection<Record> records){
		return engine.batchProcess(records);
	}
	
	public void enableLog(){
		this.engine.registerCallback(new CompressionLogger());
		this.engine.registerCallback(this.report);
	}
	
	public void generateReport(){
		if(report != null)
			report.print();
	}

}
