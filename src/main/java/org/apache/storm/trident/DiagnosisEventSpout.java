package org.apache.storm.trident;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import storm.trident.spout.ITridentSpout;

public class DiagnosisEventSpout implements ITridentSpout<Long>{
	
	SpoutOutputCollector collector;
	BatchCoordinator<Long> coordinator = new DefaultCoordinator();
	Emitter<Long> emitter = new DiagnosisEventEmmiter();

	public Map getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	public BatchCoordinator<Long> getCoordinator(String txStateId, Map conf, TopologyContext context) {
		
		return coordinator;
	}

	public Emitter<Long> getEmitter(String arg0, Map arg1, TopologyContext arg2) {
		// TODO Auto-generated method stub
		return emitter;
	}

	public Fields getOutputFields() {
		// TODO Auto-generated method stub
		return new Fields("event");
	}

}
