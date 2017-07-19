package org.apache.storm.trident;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import storm.trident.spout.ITridentSpout.BatchCoordinator;

public class DefaultCoordinator implements BatchCoordinator<Long>,Serializable {
	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultCoordinator.class);

	public void close() {

	}

	public Long initializeTransaction(long txid, Long prevMetadata, Long currMetadata) {
		LOG.info("Initializing Transaction [ " + txid + "]");
		return null;
	}

	public boolean isReady(long txid) {
		return true;
	}

	public void success(long txid) {
		LOG.info("successful Transaction [" + txid + "]");
	}

}
