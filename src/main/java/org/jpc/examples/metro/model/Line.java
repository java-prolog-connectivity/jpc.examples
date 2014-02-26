package org.jpc.examples.metro.model;



public interface Line {
	
	public String getName();
	
	public boolean connects(Station s1, Station s2);

	public long segments();

}
