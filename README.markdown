DataCollector
======

Implementacao do metodo de compressao Swinging Doors

Exemplo
--------

	DataCollector collector = new DataCollector();
		
	collector.enableLog();
		
	List<Record> rawData = Simulator.generateData(1000l, new SineWaveGenerator(100));
			
	List<Record> compressedData = collector.submit(rawData);
		
	collector.generateReport();
		
	new CompressionResultChart(rawData, compressedData).render();

Result
-------------

![Result Trend](http://i1238.photobucket.com/albums/ff487/wpivotto/Imagem2.png)


Author
------

William Pivotto :: wpivotto@gmail.com

