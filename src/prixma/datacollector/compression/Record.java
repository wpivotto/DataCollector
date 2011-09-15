package prixma.datacollector.compression;



public interface Record {

	Long getTimestamp();
	
	Long getCompressionMaximumTime(); 
	
	Long getCompressionMinimumTime(); 
	
	Deadband getDeadband();
	
	boolean isOutside(Deadband deadband);
	
	Double getValue();
	
	void setCompressionDeviation(Double deviation);
	
	Double getCompressionDeviation();
	
}
