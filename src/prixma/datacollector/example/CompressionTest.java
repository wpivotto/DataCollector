package prixma.datacollector.example;

import generators.SineWaveGenerator;

import java.util.List;

import prixma.datacollector.compression.Record;
import prixma.datacollector.impl.DataCollector;

public class CompressionTest {

	public void execute(){
		
		DataCollector collector = new DataCollector();
		
		collector.enableLog();
		
		List<Record> rawData = Simulator.generateData(1000l, new SineWaveGenerator(100));
			
		List<Record> compressedData = collector.submit(rawData);
		
		collector.generateReport();
		
		new CompressionResultChart(rawData, compressedData).render();
		
	}
	
	
	public static void main(String[] args) {

		new CompressionTest().execute();
		
	}
	

}
