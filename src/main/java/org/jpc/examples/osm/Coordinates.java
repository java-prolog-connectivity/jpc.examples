package org.jpc.examples.osm;

import org.jpc.term.TermConvertable;

public interface Coordinates extends TermConvertable {

	public double getLon();
	
	public double getLat();

}
