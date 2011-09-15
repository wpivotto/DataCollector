package prixma.datacollector.example;

import generators.Generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import prixma.datacollector.compression.Record;
import prixma.datacollector.compression.RecordOrder;

public class Simulator {
	
	
	public static List<Record> generateData(Long size, Generator<Double> generator){
		
		List<Record> data = new ArrayList<Record>();
		
		Long i = 0l;
	
		while(i < size){
			
			SampleRecord record = new SampleRecord("Record " + i);
			record.setId(1l);
			record.setCompressionDeviation(1.5d);
			record.setTimestamp(i);
			record.setValue(generator.next());
			
			data.add(record);
			
			i++;
			
		}
		
		Collections.sort(data, RecordOrder.ByTimestamp);
		
		return data;
		
	}

}
