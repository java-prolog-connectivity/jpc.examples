package org.jpc.examples.metro.model.hlapi;

import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.MetroFactory;
import org.jpc.examples.metro.model.Station;


public class MetroFactoryHLApi implements MetroFactory {

	@Override
	public Station station(String name) {
		return new StationHLApi(name);
	}
	
	@Override
	public Line line(String name) {
		return new LineHLApi(name);
	}

	@Override
	public Metro metro() {
		return new MetroHLApi();
	}
	
}
