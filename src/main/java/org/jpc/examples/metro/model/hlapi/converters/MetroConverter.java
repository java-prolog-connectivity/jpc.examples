package org.jpc.examples.metro.model.hlapi.converters;

import static org.jconverter.converter.ConversionGoal.conversionGoal;

import org.jconverter.converter.DelegateConversionException;
import org.jconverter.converter.TypeDomain;
import org.jpc.Jpc;
import org.jpc.mapping.converter.FromTermConverter;
import org.jpc.mapping.converter.ToTermConverter;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.hlapi.MetroHLApi;
import org.jpc.term.Atom;

public class MetroConverter implements ToTermConverter<Metro, Atom>, FromTermConverter<Atom, Metro> {

	public static final String METRO_ATOM_NAME = "metro";
	
	@Override
	public Atom toTerm(Metro metro, TypeDomain target, Jpc context) {
		return new Atom(METRO_ATOM_NAME);
	}
	
	@Override
	public Metro fromTerm(Atom term, TypeDomain target, Jpc context) {
		if(!term.hasFunctor("metro", 0))
			throw new DelegateConversionException(conversionGoal(term, target));
		return new MetroHLApi();
	}
	
}
