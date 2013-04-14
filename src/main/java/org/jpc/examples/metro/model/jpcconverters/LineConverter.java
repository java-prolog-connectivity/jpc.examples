package org.jpc.examples.metro.model.jpcconverters;

import static java.util.Arrays.asList;

import org.jpc.Jpc;
import org.jpc.converter.JpcConversionException;
import org.jpc.converter.JpcConverter;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.imp.LineJpc;
import org.jpc.term.Atom;
import org.jpc.term.Compound;

public class LineConverter extends JpcConverter<Line,Compound> {

	public static final String LINE_FUNCTOR = "line";
	
	@Override
	public Compound toTerm(Line line, Jpc context) {
		return new Compound(LINE_FUNCTOR, asList(new Atom(line.getName())));
	}
	
	@Override
	public Line fromTerm(Compound term, Jpc context) {
		if(!term.hasFunctor(LINE_FUNCTOR, 1))
			throw new JpcConversionException();
		String lineName = ((Atom)term.arg(1)).getName();
		return new LineJpc(lineName);
	}
	
}
