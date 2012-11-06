package org.jpc.examples.metro;

import java.util.List;

public interface IStation {
	
	public abstract boolean connected(IStation station);

	public abstract long numberConnections();

	public abstract IStation connected(ILine line);

	public abstract List<IStation> connected();

	public abstract boolean nearby(IStation station);

	public abstract long numberNearbyStations();

	public abstract List<IStation> nearby();

	public abstract boolean reachable(IStation station);
	
	public abstract long numberReachableStations();

	public abstract List<IStation> intermediateStations(IStation station);

}
