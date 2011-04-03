package prixma.datacollector.algorithm;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import prixma.datacollector.compression.Record;


public class EventQueue implements Iterable<Record> {
	
	private BlockingQueue<Record> queue = new LinkedBlockingQueue<Record>();
	
	public void stored(Record record){
		clear();
		queue.add(record);
	}
	
	public void add(Record record){
		queue.add(record);
	}
	
	public boolean isFirstEvent(){
		return queue.size() == 1;
	}
	
	private void clear(){
		queue.clear();
	}
	
	public Record getLastStored(){
		return queue.peek();
	}

	@Override
	public Iterator<Record> iterator() {
		return queue.iterator();
	}
	
}
