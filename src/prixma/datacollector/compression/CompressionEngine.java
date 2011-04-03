package prixma.datacollector.compression;

import java.util.Collection;
import java.util.List;

public interface CompressionEngine {
	
	Record process(Record candidate);
		
	List<Record> batchProcess(Collection<Record> records);

	void enableLog();

	void enableStats();
	
	void registerCallback(CompressionCallback callback);

}
