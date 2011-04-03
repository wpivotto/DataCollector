package prixma.datacollector.algorithm;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import prixma.datacollector.compression.CompressionAlgorithm;
import prixma.datacollector.compression.CompressionCallback;
import prixma.datacollector.compression.CompressionEngine;
import prixma.datacollector.compression.CompressionLogger;
import prixma.datacollector.compression.CompressionReport;
import prixma.datacollector.compression.EventNotifier;
import prixma.datacollector.compression.Record;
import prixma.datacollector.compression.RecordOrder;

public class DefaultEngine implements CompressionEngine {
	
	private EventNotifier notifier;
	
	private EventsProcessor processor;
	
	private CompressionReport report;
	
	private final CompressionAlgorithm algorithm;

	public DefaultEngine() {
		this(new SwingingDoorAlgorithm());
	}
	
	public DefaultEngine(CompressionAlgorithm algorithm) {
		this.notifier = new EventNotifier();
		this.processor = new EventsProcessor();
		registerCallback(this.processor);
		this.algorithm = algorithm;
	}
	
	
	public void enableStats(){
		this.report = new CompressionReport();
		registerCallback(this.report);
	}
	
	public void enableLog(){
		registerCallback(new CompressionLogger());
	}
	
	public Record process(Record candidate) {
		
		notifier.received(candidate);
		
		Record result = algorithm.submit(candidate, processor);
			
		if(result != null)
			notifier.approved(result);
		
		notifier.rejected(candidate);
			
		return result;	
		
	}
	
	public List<Record> batchProcess(Collection<Record> records) {
		
		List<Record> results = new ArrayList<Record>();
		
		for(Record record : records){
			Record result = process(record);
			if(result != null)
				results.add(result);
		}
		
		Collections.sort(results, RecordOrder.ByTimestamp);
		
		generateReport();
		
		return results;
		
	}
	
	public void registerCallback(CompressionCallback callback) {
		notifier.register(callback);
	}
	
	public void generateReport(){
		if(report != null)
			report.print();
	}

}
