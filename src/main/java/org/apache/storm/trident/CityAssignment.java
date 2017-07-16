package org.apache.storm.trident;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

public class CityAssignment extends BaseFunction {
	private static final Logger LOG = LoggerFactory.getLogger(CityAssignment.class);
	private static Map<String,double[]> CITIES = new HashMap<String,double[]>();
	{
		double[] phl = {39.875365,-75.249524};
		CITIES.put("phl", phl);
		double[] nyc = {40.71448,-74.00598};
		CITIES.put("NYC",nyc);
		double[] sf = {-31.4250142,-62.0841809};
		CITIES.put("SF",sf);
		double[] la = {-34.05374,-118.24307};
		CITIES.put("LA",la);
		
	}

	public void execute(TridentTuple tuple, TridentCollector collector) {
		// TODO Auto-generated method stub
		
	}


}
