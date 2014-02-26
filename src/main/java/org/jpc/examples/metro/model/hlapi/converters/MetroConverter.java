package org.jpc.examples.metro.model.hlapi.converters;

import java.lang.reflect.Type;

import org.jconverter.converter.ConversionException;
import org.jpc.Jpc;
import org.jpc.converter.FromTermConverter;
import org.jpc.converter.ToTermConverter;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.hlapi.MetroHLApi;
import org.jpc.term.Atom;

public class MetroConverter implements ToTermConverter<Metro, Atom>, FromTermConverter<Atom, Metro> {

	public static final String METRO_ATOM_NAME = "metro";
	
	@Override
	public Atom toTerm(Metro metro, Class<Atom> termClass, Jpc context) {
		return new Atom(METRO_ATOM_NAME);
	}
	
	@Override
	public Metro fromTerm(Atom term, Type type, Jpc context) {
		if(!term.hasFunctor("metro", 0))
			throw new ConversionException();
		return new MetroHLApi();
	}
	
}
