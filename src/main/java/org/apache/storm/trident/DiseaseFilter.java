package org.apache.storm.trident;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import storm.trident.operation.BaseFilter;
import storm.trident.tuple.TridentTuple;

public class DiseaseFilter extends BaseFilter {
	private static final Logger LOG = LoggerFactory.getLogger(DiseaseFilter.class);

	public boolean isKeep(TridentTuple tuple) {
		DiagnosisEvent diagnosis = (DiagnosisEvent) tuple.getValue(0);
		Integer code = Integer.parseInt(diagnosis.diagnosisCode);
		if (code.intValue() <= 322) {
			LOG.debug("Emitting disease [" + diagnosis.diagnosisCode + "]");
			return true;
		} else {
			LOG.debug("Filter disease [" + diagnosis.diagnosisCode + "]");
			return false;
		}

	}

}
