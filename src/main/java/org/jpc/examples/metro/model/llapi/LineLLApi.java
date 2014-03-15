package org.jpc.examples.metro.model.llapi;

import static java.util.Arrays.asList;
import static org.jpc.engine.prolog.PrologEngines.getPrologEngine;
import static org.jpc.term.Var.ANONYMOUS_VAR;

import org.jpc.engine.logtalk.LogtalkConstants;
import org.jpc.engine.prolog.PrologEngine;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Station;
import org.jpc.query.Query;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;

public class LineLLApi implements Line {

	public static final String LINE_FUNCTOR_NAME = "line";
	
	public static LineLLApi create(Term lineTerm) {
		return new LineLLApi(((Atom)lineTerm.arg(1)).getName());
	}
	
	
	private final String name;
	private final PrologEngine prologEngine;
	
	public LineLLApi(String name) {
		this.name = name;
		prologEngine = getPrologEngine(getClass());
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {return name;}

	
	public Compound asTerm() {
		return new Compound(LINE_FUNCTOR_NAME, asList(new Atom(getName())));
	}
	
	@Override
	public boolean connects(Station s1, Station s2) {
		Term message = new Compound("connects", asList(((StationLLApi)s1).asTerm(), ((StationLLApi)s2).asTerm()));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		return query.hasSolution();
	}

	@Override
	public long segments() {
		Term message = new Compound("connects", asList(ANONYMOUS_VAR, ANONYMOUS_VAR));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		return query.numberOfSolutions();
	}
	
}
