package org.jpc.examples.metro.model;

import org.jpc.examples.metro.MetroExample;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.Station;

/**
 * The base class of the test classes for the metro example
 * @author sergioc
 *
 */
public abstract class AbstractMetroTest {

	public Metro metro() {
		return MetroExample.getFactory().metro();
	}

	public Line line(String name) {
		return MetroExample.getFactory().line(name);
	}

	public Station station(String name) {
		return MetroExample.getFactory().station(name);
	}

}
