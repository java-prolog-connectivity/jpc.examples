package org.jpc.examples.metro.model;

import java.util.List;

public interface Station {
	
	public String getName();
	
	public boolean connected(Station station);

	public long numberConnections();

	public Station connected(Line line);

	public List<Station> connected();

	public boolean nearby(Station station);

	public long numberNearbyStations();

	public List<Station> nearby();

	public boolean reachable(Station station);
	
	public long numberReachableStations();

	public List<Station> intermediateStations(Station station);

}
