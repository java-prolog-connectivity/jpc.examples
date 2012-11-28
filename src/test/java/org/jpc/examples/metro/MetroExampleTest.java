package org.jpc.examples.metro;

import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Metro;
import org.jpc.examples.metro.MetroFactory;
import org.jpc.examples.metro.Station;
import org.jpc.examples.metro.imp.MetroFactoryImp;

/**
 * The base class of the test classes for the metro example
 * @author sergioc
 *
 */
public class MetroExampleTest {

	private MetroFactory defaultFactory;
	
	public MetroFactory getMetroFactory() {
		if(defaultFactory == null)
			defaultFactory = new MetroFactoryImp();
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
