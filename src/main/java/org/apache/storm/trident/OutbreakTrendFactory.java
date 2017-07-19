package org.apache.storm.trident;

import java.util.Map;

import backtype.storm.task.IMetricsContext;
import storm.trident.state.State;
import storm.trident.state.StateFactory;
import trident.state.OutbreakTrendBackingMap;
import trident.state.OutbreakTrendState;

public class OutbreakTrendFactory implements StateFactory {

	public State makeState(Map conf, IMetricsContext metrics, int partitionIndex, int numPartitions) {
		  return new OutbreakTrendState(new OutbreakTrendBackingMap());
	}

}
