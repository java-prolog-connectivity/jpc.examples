package org.jpc.examples.osm.imp;

import static java.util.Arrays.asList;
import java.util.Map;

import org.jpc.converter.fromterm.fromlistterm.ListTermToMapConverter;
import org.jpc.converter.toterm.tolistterm.MapToTermConverter;
import org.jpc.examples.osm.Coordinates;
import org.jpc.examples.osm.Node;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;

public class NodeImp implements Node {

	public static final String NODE_FUNCTOR = "node"; //node prolog functor

	public static Node create(Term term) {
		String id = ((Atom)term.arg(1)).getName();
		Coordinates coordinates = CoordinatesImp.create(term.arg(2));
		Map tags = new ListTermToMapConverter().apply(term.arg(3));
		return new NodeImp(id, coordinates, tags);
	}

	private String id;
	private Coordinates coordinates;
	private Map<String,String> tags;

	public NodeImp(String id, Coordinates coordinates, Map<String,String> tags) {
		this.id = id;
		this.coordinates = coordinates;
		this.tags = tags;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public Coordinates getCoordinates() {
		return coordinates;
	}


	@Override
	public Map<String, String> getTags() {
		return tags;
	}

	
	@Override
	public Term asTerm() {
		return new Compound(NODE_FUNCTOR, asList(new Atom(id), coordinates, new MapToTermConverter().apply(tags)));
	}
	
	
}
