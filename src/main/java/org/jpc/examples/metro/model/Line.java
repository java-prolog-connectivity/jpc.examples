package org.jpc.examples.metro.model;


/**
 * An underground line.
 * @author sergioc
 *
 */
public interface Line {
	
	/**
	 * 
	 * @return the line name.
	 */
	public String getName();
	
	/**
	 * 
	 * @param s1 a station.
	 * @param s2 a station.
	 * @return true if the given stations are connected by means of this line. false otherwise.
	 */
	public boolean connects(Station s1, Station s2);

	/**
	 * 
	 * @return the number of segments of this line.
	 */
	public long segments();

}
