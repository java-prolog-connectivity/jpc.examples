package org.jpc.examples.osm;

import java.util.Map;

import org.jpc.term.TermConvertable;

public interface Node extends TermConvertable {

	public String getId();
	
	public Coordinates getCoordinates();
	
	public Map<String, String> getTags();

}
