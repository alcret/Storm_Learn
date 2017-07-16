package org.apache.storm.trident;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.tuple.Fields;
import storm.trident.Stream;
import storm.trident.TridentTopology;
import storm.trident.operation.builtin.Count;

public class OutbreakDetectionTopology {
	public static StormTopology buildTopology() {
		TridentTopology topology = new TridentTopology();
		DiagnosisEventSpout spout = new DiagnosisEventSpout();
		Stream inputStream = topology.newStream("event", spout);

		inputStream.each(new Fields("event"), new DiseaseFilter())
				.each(new Fields("event"), new CityAssignment(), new Fields("city"))
				.each(new Fields("event", "city"), new HourAssignment(), new Fields("hour", "cityDiseaseHour"))
				.groupBy(new Fields("cityDiseaseHour"))
				.persistentAggregate(new OutbreakTrendFactory(), new Count(), new Fields("count")).newValuesStream()
				.each(new Fields("cityDiseaseHour", "count"), new OutbreakDetector(), new Fields("alert"))
				.each(new Fields("alert"), new DispatchAlert(), new Fields());
		return topology.build();

	}

	public static void main(String[] args) throws InterruptedException {
		Config config = new Config();
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("cdc", config, buildTopology());
		Thread.sleep(200000);
		cluster.shutdown();

	}
}
