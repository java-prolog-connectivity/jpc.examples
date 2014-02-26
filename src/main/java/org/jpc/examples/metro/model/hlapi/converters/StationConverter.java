package org.jpc.examples.metro.model.hlapi.converters;

import static java.util.Arrays.asList;

import java.lang.reflect.Type;

import org.jconverter.converter.ConversionException;
import org.jpc.Jpc;
import org.jpc.converter.FromTermConverter;
import org.jpc.converter.ToTermConverter;
import org.jpc.examples.metro.model.Station;
import org.jpc.examples.metro.model.hlapi.StationHLApi;
import org.jpc.term.Atom;
import org.jpc.term.Compound;

public class StationConverter implements ToTermConverter<Station, Compound>, FromTermConverter<Compound, Station> {

	public static final String STATION_FUNCTOR_NAME = "station";
	
	@Override
	public Compound toTerm(Station station, Class<Compound> termClass, Jpc context) {
		return new Compound(STATION_FUNCTOR_NAME, asList(new Atom(station.getName())));
	}
	
	@Override
	public Station fromTerm(Compound term, Type type, Jpc context) {
		if(!term.hasFunctor(STATION_FUNCTOR_NAME, 1))
			throw new ConversionException();
		String stationName = ((Atom)term.arg(1)).getName();
		return new StationHLApi(stationName);
	}

}
