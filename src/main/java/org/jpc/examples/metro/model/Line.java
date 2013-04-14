package org.jpc.examples.metro.model;



public interface Line {
	
	public abstract String getName();
	
	public abstract boolean connects(Station s1, Station s2);

	public abstract long segments();

}
