package org.jpc.examples.metro.imp;

import org.jpc.converter.fromterm.TermToObjectConverter;
import org.jpc.examples.metro.Station;
import org.jpc.term.Atom;
import org.jpc.term.Term;

public class TermToStationConverter implements TermToObjectConverter<Station> {

	@Override
	public Station apply(Term term) {
		String stationName = ((Atom)term.arg(1)).getName();
		return new StationImp(stationName);
	}

}
