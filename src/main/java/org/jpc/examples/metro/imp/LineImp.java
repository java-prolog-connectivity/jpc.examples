package org.jpc.examples.metro.imp;

import static java.util.Arrays.asList;
import static org.jpc.term.Variable.ANONYMOUS_VAR;
import static org.jpc.util.ThreadLocalLogicEngine.getLogicEngine;

import java.util.Arrays;

import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.engine.prolog.Query;
import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Station;
import org.jpc.term.AbstractTerm;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.TermConvertable;

public class LineImp implements Line, TermConvertable {

	public static final String LINE_FUNCTOR = "line";
	
	private String name;
	
	public LineImp(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {return name;}
	
	public AbstractTerm asTerm() {
		return new Compound(LINE_FUNCTOR, Arrays.asList(new Atom(name)));
	}
	
	public static Line create(Term term) {
		Compound lineTerm = (Compound)term;
		String lineName = ((Atom)lineTerm.arg(1)).getName();
		return new LineImp(lineName);
	}


	public boolean connects(Station s1, Station s2) {
		AbstractTerm message = new Compound("connects", asList((TermConvertable)s1,(TermConvertable)s2));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		return query.hasSolution();
	}


	public long segments() {
		AbstractTerm message = new Compound("connects", asList(ANONYMOUS_VAR, ANONYMOUS_VAR));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		return query.numberOfSolutions();
	}
	
}
