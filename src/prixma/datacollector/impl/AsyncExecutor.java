package prixma.datacollector.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import prixma.datacollector.compression.CompressionEngine;
import prixma.datacollector.compression.Record;

public class AsyncExecutor {
	
	private final ExecutorService executor;
	private static AsyncExecutor instance = null;
	
	private AsyncExecutor() {
		executor = Executors.newCachedThreadPool();
	}

	public static AsyncExecutor New(){
		if(instance == null)
			instance = new AsyncExecutor();
		return instance;
	}
	
	public List<Record> submit(final CompressionEngine engine, final Collection<Record> records){
		
		CompressionTask task = new CompressionTask(engine, records);
		
		Future<List<Record>> future = executor.submit(task);
		
		try {
			
			return future.get();
		
		} catch (InterruptedException e) {
			return Collections.emptyList();
		} catch (ExecutionException e) {
			return Collections.emptyList();
		}
			
	}
	
	public void shutdown(){
		this.executor.shutdown();
	}
	

}
