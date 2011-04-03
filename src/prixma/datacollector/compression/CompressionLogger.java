package prixma.datacollector.compression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompressionLogger implements CompressionCallback {

	private static final Logger Log = LoggerFactory.getLogger(CompressionLogger.class);
	
	@Override
	public void approved(Record record) {
		Log.info("Store " + record);
	}

	@Override
	public void rejected(Record record) {
		Log.info("Discard " + record);
	}

	@Override
	public void received(Record record) {
		Log.info("Processing " + record);
	}

}
