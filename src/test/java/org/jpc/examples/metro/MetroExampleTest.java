package org.jpc.examples.metro;

import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.MetroFactory;
import org.jpc.examples.metro.model.Station;
import org.jpc.examples.metro.model.imp.MetroFactoryJpc;

/**
 * The base class of the test classes for the metro example
 * @author sergioc
 *
 */
public class MetroExampleTest {

	private MetroFactory defaultFactory;
	
	public MetroFactory getMetroFactory() {
		if(defaultFactory == null)
			defaultFactory = new MetroFactoryJpc();
		return defaultFactory;
	}
	
	public void setMetroFactory(MetroFactory factory) {
		defaultFactory = factory;
	}

	public Metro metro() {
		return getMetroFactory().metro();
	}

	public Line line(String name) {
		return getMetroFactory().line(name);
	}

	public Station station(String name) {
		return getMetroFactory().station(name);
	}

}
