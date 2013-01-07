package org.jpc.examples.osm.imp;

import static java.util.Arrays.asList;

import org.jpc.examples.osm.Coordinates;
import org.jpc.term.Compound;
import org.jpc.term.FloatTerm;
import org.jpc.term.Term;
import org.jpc.term.TermConvertable;

public class CoordinatesImp implements Coordinates {

	public static final String COORDINATES_FUNCTOR = "coordinates"; //coordinates prolog functor

	public static Coordinates create(Term term) {
		return new CoordinatesImp(((FloatTerm)term.arg(1)).doubleValue(), ((FloatTerm)term.arg(2)).doubleValue());
	}
	
	private double lon;
	private double lat;
	
	public CoordinatesImp(double lon, double lat) {
		this.lon = lon;
		this.lat = lat;
	}
	
	@Override
	public double getLon() {
		return lon;
	}

	@Override
	public double getLat() {
		return lat;
	}

	
	@Override
	public Term asTerm() {
		return new Compound(COORDINATES_FUNCTOR, asList(new FloatTerm(lon), new FloatTerm(lat)));
	}

}
