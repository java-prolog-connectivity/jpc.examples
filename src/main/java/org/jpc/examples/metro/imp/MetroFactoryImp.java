package org.jpc.examples.metro.imp;

import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Metro;
import org.jpc.examples.metro.MetroFactory;
import org.jpc.examples.metro.Station;


public class MetroFactoryImp implements MetroFactory {

	@Override
	public Station station(String name) {
		return new StationImp(name);
	}
	
	@Override
	public Line line(String name) {
		return new LineImp(name);
	}

	@Override
	public Metro metro() {
		return new MetroImp();
	}
	
}
