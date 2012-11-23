package org.jpc.examples.metro;


public interface Line {
	
	public boolean connects(Station s1, Station s2);

	public long segments();

}
