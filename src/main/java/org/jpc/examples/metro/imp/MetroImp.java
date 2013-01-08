package org.jpc.examples.metro.imp;

import static java.util.Arrays.asList;
import static org.jpc.examples.metro.imp.LineImp.LINE_FUNCTOR;
import static org.jpc.util.ThreadLocalLogicEngine.getLogicEngine;

import java.util.List;

import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Metro;
import org.jpc.query.Query;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.TermConvertable;
import org.jpc.term.Variable;

public class MetroImp implements Metro {

	public static final String METRO_FUNCTOR = "metro";
	
	@Override
	public String toString() {return METRO_FUNCTOR;}
	
	@Override
	public Term asTerm() {
		return new Atom(METRO_FUNCTOR);
	}

	
	@Override
	public List<Line> lines() {
		String lineVarName = "Line";
		Term message = new Compound(LINE_FUNCTOR, asList(new Variable(lineVarName)));
		Query query = new LogtalkObject(this, getLogicEngine()).perform(message);
		return query.select(new Compound(LINE_FUNCTOR, asList(new Variable(lineVarName)))).adapt(new TermToLineConverter()).allSolutions();
	}

	@Override
	public Line line(String name) {
		Line line = null;
		Term message = new Compound(LINE_FUNCTOR, asList(new Atom(name)));
		Query query = new LogtalkObject(this, getLogicEngine()).perform(message);
		if(query.hasSolution())
			line = new LineImp(name);
		return line;
	}
	
}
