package org.jpc.examples.metro.model.llapi;

import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.MetroFactory;
import org.jpc.examples.metro.model.Station;

public class MetroFactoryLLApi implements MetroFactory {

	@Override
	public Station station(String name) {
		return new StationLLApi(name);
	}
	
	@Override
	public Line line(String name) {
		return new LineLLApi(name);
	}

	@Override
	public Metro metro() {
		return new MetroLLApi();
	}

}
