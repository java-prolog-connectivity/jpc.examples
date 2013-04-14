package org.jpc.examples.metro.model;

import java.util.List;

public interface Station {
	
	public abstract String getName();
	
	public abstract boolean connected(Station station);

	public abstract long numberConnections();

	public abstract Station connected(Line line);

	public abstract List<Station> connected();

	public abstract boolean nearby(Station station);

	public abstract long numberNearbyStations();

	public abstract List<Station> nearby();

	public abstract boolean reachable(Station station);
	
	public abstract long numberReachableStations();

	public abstract List<Station> intermediateStations(Station station);

}
