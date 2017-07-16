package org.apache.storm.trident;

import java.io.Serializable;

public class DiagnosisEvent implements Serializable{
	public double lat;
	public double lng;
	public long time;
	public String diagnosisCode;
	public DiagnosisEvent(double lat, double lng, long time, String diagnosisCode) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.time = time;
		this.diagnosisCode = diagnosisCode;
	}
	
}
