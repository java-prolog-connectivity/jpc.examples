package org.jpc.examples.metro;

import java.util.List;

import org.jpc.term.TermConvertable;

public interface Station extends TermConvertable {
	
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
