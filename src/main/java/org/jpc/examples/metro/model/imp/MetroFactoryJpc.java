package org.jpc.examples.metro.model.imp;

import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.MetroFactory;
import org.jpc.examples.metro.model.Station;


public class MetroFactoryJpc implements MetroFactory {

	@Override
	public Station station(String name) {
		return new StationJpc(name);
	}
	
	@Override
	public Line line(String name) {
		return new LineJpc(name);
	}

	@Override
	public Metro metro() {
		return new MetroJpc();
	}
	
}
