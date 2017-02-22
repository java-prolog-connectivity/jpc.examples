package org.jpc.examples.metro.model.hlapi.converters;

import static java.util.Arrays.asList;
import static org.jconverter.converter.ConversionGoal.conversionGoal;

import org.jconverter.converter.DelegateConversionException;
import org.jconverter.converter.TypeDomain;
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
	public Compound toTerm(Station station, TypeDomain target, Jpc context) {
		return new Compound(STATION_FUNCTOR_NAME, asList(new Atom(station.getName())));
	}
	
	@Override
	public Station fromTerm(Compound term, TypeDomain target, Jpc context) {
		if(!term.hasFunctor(STATION_FUNCTOR_NAME, 1))
			throw new DelegateConversionException(conversionGoal(term, target));
		String stationName = ((Atom)term.arg(1)).getName();
		return new StationHLApi(stationName);
	}

}
