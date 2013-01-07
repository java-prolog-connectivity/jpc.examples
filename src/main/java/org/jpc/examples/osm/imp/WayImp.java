package org.jpc.examples.osm.imp;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Map;

import org.jpc.converter.fromterm.fromlistterm.ListTermToListConverter;
import org.jpc.converter.fromterm.fromlistterm.ListTermToMapConverter;
import org.jpc.converter.toterm.tolistterm.IterableToTermConverter;
import org.jpc.converter.toterm.tolistterm.MapToTermConverter;
import org.jpc.examples.osm.Way;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;

public class WayImp implements Way {

	public static final String WAY_FUNCTOR = "way"; //way prolog functor

	public static Way create(Term term) {
		String id = ((Atom)term.arg(1)).getName();
		List nodesIds = new ListTermToListConverter().apply(term.arg(2));
		Map tags = new ListTermToMapConverter().apply(term.arg(3));
		return new WayImp(id, nodesIds, tags);
	}
	
	private String id;
	private List<String> nodesIds;
	private Map<String,String> tags;
	
	public WayImp(String id, List<String> nodesIds, Map<String,String> tags) {
		this.id = id;
		this.nodesIds = nodesIds;
		this.tags = tags;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public List<String> getNodesIds() {
		return nodesIds;
	}

	@Override
	public Map<String, String> getTags() {
		return tags;
	}

	@Override
	public Term asTerm() {
		return new Compound(WAY_FUNCTOR, asList(new Atom(id), new IterableToTermConverter().apply(nodesIds), new MapToTermConverter().apply(tags)));
	}

}
