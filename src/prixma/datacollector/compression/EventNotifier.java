package prixma.datacollector.compression;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


public class EventNotifier {
	
	private Set<CompressionCallback> listeners;
	
	public EventNotifier() {
		this.listeners = new CopyOnWriteArraySet<CompressionCallback>();
	}

	public void register(CompressionCallback listener) {
		listeners.add(listener);
	}
	
	public void approved(Record record){
		
		for(CompressionCallback callback : listeners){
			callback.approved(record);
		}
		
	}
	
	public void rejected(Record record){
		
		for(CompressionCallback callback : listeners){
			callback.rejected(record);
		}
		
	}

	public void received(Record record) {
		
		for(CompressionCallback callback : listeners){
			callback.received(record);
		}
		
	}

}
