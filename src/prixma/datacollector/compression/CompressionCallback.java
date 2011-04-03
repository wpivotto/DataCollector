	package prixma.datacollector.compression;


public interface CompressionCallback {
	
	void approved(Record record);
	
	void rejected(Record record);
	
	void received(Record record);
	

}
