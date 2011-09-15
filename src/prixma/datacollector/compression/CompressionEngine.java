package prixma.datacollector.compression;

import java.util.Collection;
import java.util.List;

public interface CompressionEngine {
		
	List<Record> batchProcess(Collection<Record> candidates);
	
	Record process(Record candidate);
	
	void registerCallback(CompressionCallback callback);
	
	void reset();

}
