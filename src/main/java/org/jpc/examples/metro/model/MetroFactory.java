package org.jpc.examples.metro.model;

/**
 * A factory of underground objects.
 * @author sergioc
 *
 */
public interface MetroFactory {
	
	/**
	 * 
	 * @return an object representing the underground system.
	 */
	public Metro metro();

	/**
	 * 
	 * @param name a station name.
	 * @return a station with the given name.
	 */
	public Station station(String name);

	/**
	 * 
	 * @param name a line name.
	 * @return a line with the given name.
	 */
	public Line line(String name);
	
}
