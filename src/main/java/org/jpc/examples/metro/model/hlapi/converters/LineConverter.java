package org.jpc.examples.metro.model.hlapi.converters;

import static java.util.Arrays.asList;
import static org.jconverter.converter.ConversionGoal.conversionGoal;

import org.jconverter.converter.DelegateConversionException;
import org.jconverter.converter.TypeDomain;
import org.jpc.Jpc;
import org.jpc.converter.FromTermConverter;
import org.jpc.converter.ToTermConverter;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.hlapi.LineHLApi;
import org.jpc.term.Atom;
import org.jpc.term.Compound;

public class LineConverter implements ToTermConverter<Line, Compound>, FromTermConverter<Compound, Line> {

	public static final String LINE_FUNCTOR_NAME = "line";
	
	@Override
	public Compound toTerm(Line line, TypeDomain target, Jpc context) {
		return new Compound(LINE_FUNCTOR_NAME, asList(new Atom(line.getName())));
	}
	
	@Override
	public Line fromTerm(Compound term, TypeDomain target, Jpc context) {
		if(!term.hasFunctor(LINE_FUNCTOR_NAME, 1))
			throw new DelegateConversionException(conversionGoal(term, target));
		String lineName = ((Atom)term.arg(1)).getName();
		return new LineHLApi(lineName);
	}
	
}
