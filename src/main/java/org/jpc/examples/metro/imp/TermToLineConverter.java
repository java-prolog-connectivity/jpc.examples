package org.jpc.examples.metro.imp;

import org.jpc.converter.fromterm.TermToObjectConverter;
import org.jpc.examples.metro.Line;
import org.jpc.term.Atom;
import org.jpc.term.Term;

public class TermToLineConverter implements TermToObjectConverter<Line> {

	@Override
	public Line apply(Term term) {
		String lineName = ((Atom)term.arg(1)).getName();
		return new LineImp(lineName);
	}

}
