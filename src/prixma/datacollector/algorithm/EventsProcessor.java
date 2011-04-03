package prixma.datacollector.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import prixma.datacollector.compression.CompressionCallback;
import prixma.datacollector.compression.Record;

public class EventsProcessor implements CompressionCallback {

	private Map<Record, EventQueue> events = new ConcurrentHashMap<Record, EventQueue>();

	public void approved(Record record) {
		getEventsFrom(record).stored(record);
	}

	public void rejected(Record record) {
		getEventsFrom(record).add(record);
	}
	
	public EventQueue getEventsFrom(Record record){
		return events.get(record);
	}

	public void received(Record record) {	
		if(!events.containsKey(record))
			events.put(record, new EventQueue());
	}
	
}
