package org.jpc.examples.metro.model;

import java.util.List;

/**
 * An underground system.
 * @author sergioc
 *
 */
public interface Metro {

	/**
	 * 
	 * @return a list of existing lines.
	 */
	public List<Line> lines();
	
	/**
	 * 
	 * @param lineName a line name.
	 * @return an existing line with the given name.
	 */
	public Line line(String lineName);
	
}
