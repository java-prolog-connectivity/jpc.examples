package org.jpc.examples.metro.model.jpcconverters;

import org.jpc.Jpc;
import org.jpc.converter.JpcConversionException;
import org.jpc.converter.JpcConverter;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.imp.MetroJpc;
import org.jpc.term.Atom;

public class MetroConverter extends JpcConverter<Metro, Atom> {

	public static final String METRO_FUNCTOR = "metro";
	
	@Override
	public Atom toTerm(Metro metro, Jpc context) {
		return new Atom(METRO_FUNCTOR);
	}
	
	@Override
	public Metro fromTerm(Atom term, Jpc context) {
		if(!term.hasFunctor("metro", 0))
			throw new JpcConversionException();
		return new MetroJpc();
	}
	
}
