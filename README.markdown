DataCollector
======

Implementacao do metodo de compressao Swinging Doors

Exemplo
--------

	DataCollector collector = new DataCollector();
		
	List<Record> rawData = Simulator.generateData(1000, new SineWaveGenerator(100));
			
	List<Record> compressedData = collector.submit(rawData);
		
	new CompressionResultChart(rawData, compressedData).render();

Output
-------------

	....
	15/09/11 17:53:08 [INFO]  Processing Record 997 [-99.2546151641322]
	15/09/11 17:53:08 [INFO]  Discard Record 997 [-99.2546151641322]
	15/09/11 17:53:08 [INFO]  Processing Record 998 [-99.02680687415703]
	15/09/11 17:53:08 [INFO]  Discard Record 998 [-99.02680687415703]
	15/09/11 17:53:08 [INFO]  Processing Record 999 [-98.7688340595138]
	15/09/11 17:53:08 [INFO]  Discard Record 999 [-98.7688340595138]
	15/09/11 17:53:08 [INFO]  ---------- COMPRESSION REPORT ----------
	15/09/11 17:53:08 [INFO]  Events: 1000
	15/09/11 17:53:08 [INFO]  Stored: 62
	15/09/11 17:53:08 [INFO]  Compression: 93.8%
	15/09/11 17:53:08 [INFO]  Ratio: 0.062
	

![Chart1](http://i1238.photobucket.com/albums/ff487/wpivotto/chart3.png)


Exemplo
-------------

<http://historian-prixma.appspot.com>

![Chart2](http://i1238.photobucket.com/albums/ff487/wpivotto/chart.png)


