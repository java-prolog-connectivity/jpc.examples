package org.jpc.examples.metro.model.hlapi.converters;

import static java.util.Arrays.asList;

import java.lang.reflect.Type;

import org.jconverter.converter.ConversionException;
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
	public Compound toTerm(Line line, Class<Compound> termClass, Jpc context) {
		return new Compound(LINE_FUNCTOR_NAME, asList(new Atom(line.getName())));
	}
	
	@Override
	public Line fromTerm(Compound term, Type type, Jpc context) {
		if(!term.hasFunctor(LINE_FUNCTOR_NAME, 1))
			throw new ConversionException();
		String lineName = ((Atom)term.arg(1)).getName();
		return new LineHLApi(lineName);
	}
	
}
