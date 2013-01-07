package org.jpc.examples.osm.imp;

import static java.util.Arrays.asList;
import static org.jpc.util.ThreadLocalLogicEngine.getLogicEngine;

import java.util.List;
import java.util.Map;

import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.examples.osm.Coordinates;
import org.jpc.examples.osm.Node;
import org.jpc.examples.osm.Osm;
import org.jpc.query.Query;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.TermConvertable;
import org.jpc.term.Variable;

public class OsmImp implements Osm {

	public static final String OSM_NAME = "osm"; //node prolog functor
	
	@Override
	public List<Node> getNodes() {
		Term message = new Compound("node",asList(Variable.ANONYMOUS_VAR, new Variable("Node")));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		return null;
	}

	@Override
	public List<Node> getNodes(Map<String, String> tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node> getNearNodes(Coordinates coordinates, double distanceKm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node> getNearNodes(Coordinates coordinates, double distanceKm, Map<String, String> tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Term asTerm() {
		return new Atom(OSM_NAME);
	}

}
