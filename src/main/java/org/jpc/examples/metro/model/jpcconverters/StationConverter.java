package org.jpc.examples.metro.model.jpcconverters;

import static java.util.Arrays.asList;

import org.jpc.Jpc;
import org.jpc.converter.JpcConversionException;
import org.jpc.converter.JpcConverter;
import org.jpc.examples.metro.model.Station;
import org.jpc.examples.metro.model.imp.StationJpc;
import org.jpc.term.Atom;
import org.jpc.term.Compound;

public class StationConverter extends JpcConverter<Station, Compound> {

	public static final String STATION_FUNCTOR = "station";
	
	@Override
	public Compound toTerm(Station station, Jpc context) {
		return new Compound(STATION_FUNCTOR, asList(new Atom(station.getName())));
	}
	
	@Override
	public Station fromTerm(Compound term, Jpc context) {
		if(!term.hasFunctor(STATION_FUNCTOR, 1))
			throw new JpcConversionException();
		String stationName = ((Atom)term.arg(1)).getName();
		return new StationJpc(stationName);
	}

}
