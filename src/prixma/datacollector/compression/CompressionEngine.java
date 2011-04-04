package prixma.datacollector.compression;

import java.util.Collection;
import java.util.List;

public interface CompressionEngine {
		
	List<Record> batchProcess(Collection<Record> records);
	
	void registerCallback(CompressionCallback callback);

}
