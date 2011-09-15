package prixma.datacollector.example;

import generators.SineWaveGenerator;

import java.util.ArrayList;
import java.util.List;

import prixma.datacollector.compression.Record;
import prixma.datacollector.impl.DataCollector;

public class CompressionTest {

	public void execute(){
		
		DataCollector collector = new DataCollector();
		
		collector.enableLog();
		
		List<Record> rawData = Simulator.generateData(100l, new SineWaveGenerator(100));
			
		List<Record> compressedData = new ArrayList<Record>();
		
		for(Record candidate : rawData){
			Record result = collector.submit(candidate);
			if(result != null)
				compressedData.add(result);
		}
	
		collector.generateReport();
		
		new CompressionResultChart(rawData, compressedData).render();
		
	}
	
	
	public static void main(String[] args) {

		new CompressionTest().execute();
		
	}
	

}
