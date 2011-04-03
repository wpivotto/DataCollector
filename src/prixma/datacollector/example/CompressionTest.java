package prixma.datacollector.example;

import generators.SineWaveGenerator;

import java.util.List;

import prixma.datacollector.algorithm.DefaultEngine;
import prixma.datacollector.algorithm.SwingingDoorAlgorithm;
import prixma.datacollector.compression.CompressionEngine;
import prixma.datacollector.compression.Record;

public class CompressionTest {
	
	private CompressionEngine getEngine(){
		
		CompressionEngine engine = new DefaultEngine(new SwingingDoorAlgorithm());
		
		engine.enableLog();
		engine.enableStats();
		
		return engine;
		
	}

	public void execute(){
		
		List<Record> rawData = Simulator.generateData(1000l, new SineWaveGenerator(100));
		
		List<Record> compressedData = getEngine().batchProcess(rawData);
		
		CompressionResultChart chart = new CompressionResultChart(rawData, compressedData);
		
		chart.render();
		
	}
	
	
	public static void main(String[] args) {

		new CompressionTest().execute();
		
	}
	

}
