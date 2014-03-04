package org.jpc.examples.metro.model;

import java.util.List;

/**
 * An underground station.
 * @author sergioc
 *
 */
public interface Station {
	
	/**
	 * 
	 * @return the station name.
	 */
	public String getName();
	
	/**
	 * 
	 * @param station
	 * @return true of this station is directly connected to the received station. false otherwise.
	 */
	public boolean connected(Station station);

	/**
	 * 
	 * @return the number of stations connected to this station.
	 */
	public long numberConnections();

	/**
	 * 
	 * @param line a line.
	 * @return a station connected to this station by means of the line given as parameter.
	 */
	public Station connected(Line line);

	/**
	 * 
	 * @return a list of stations connected with this station.
	 */
	public List<Station> connected();

	/**
	 * 
	 * @param station a station.
	 * @return true if this station is nearby the given station. false otherwise.
	 */
	public boolean nearby(Station station);

	/**
	 * 
	 * @return the number of nearby stations.
	 */
	public long numberNearbyStations();

	/**
	 * 
	 * @return a list of stations nearby this station.
	 */
	public List<Station> nearby();

	/**
	 * 
	 * @param station a station.
	 * @return true if the given station is reachable from this station.
	 */
	public boolean reachable(Station station);
	
	/**
	 * 
	 * @return the number of reachable stations.
	 */
	public long numberReachableStations();

	/**
	 * 
	 * @param station a station.
	 * @return a list with all the intermediate stations between this station and the passed station.
	 */
	public List<Station> intermediateStations(Station station);

}
