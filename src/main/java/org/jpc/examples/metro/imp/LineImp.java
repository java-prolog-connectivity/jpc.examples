package org.jpc.examples.metro.imp;

import static java.util.Arrays.asList;
import static org.jpc.term.Variable.ANONYMOUS_VAR;
import static org.jpc.util.ThreadLocalLogicEngine.getLogicEngine;

import java.util.Arrays;

import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Station;
import org.jpc.query.Query;
import org.jpc.term.AbstractTerm;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.TermConvertable;

public class LineImp implements Line {

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
	
	@Override
	public Term asTerm() {
		return new Compound(LINE_FUNCTOR, asList(new Atom(name)));
	}

	public boolean connects(Station s1, Station s2) {
		Term message = new Compound("connects", asList(s1,s2));
		Query query = new LogtalkObject(this, getLogicEngine()).perform(message);
		return query.hasSolution();
	}


	public long segments() {
		Term message = new Compound("connects", asList(ANONYMOUS_VAR, ANONYMOUS_VAR));
		Query query = new LogtalkObject(this, getLogicEngine()).perform(message);
		return query.numberOfSolutions();
	}
	
}
