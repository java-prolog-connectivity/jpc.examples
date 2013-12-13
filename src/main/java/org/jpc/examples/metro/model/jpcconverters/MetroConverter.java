package org.jpc.examples.metro.model.jpcconverters;

import java.lang.reflect.Type;

import org.jconverter.converter.ConversionException;
import org.jpc.Jpc;
import org.jpc.converter.FromTermConverter;
import org.jpc.converter.ToTermConverter;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.imp.MetroJpc;
import org.jpc.term.Atom;

public class MetroConverter implements ToTermConverter<Metro, Atom>, FromTermConverter<Atom, Metro> {

	public static final String METRO_FUNCTOR = "metro";
	
	@Override
	public Atom toTerm(Metro metro, Class<Atom> termClass, Jpc context) {
		return new Atom(METRO_FUNCTOR);
	}
	
	@Override
	public Metro fromTerm(Atom term, Type type, Jpc context) {
		if(!term.hasFunctor("metro", 0))
			throw new ConversionException();
		return new MetroJpc();
	}
	
}
