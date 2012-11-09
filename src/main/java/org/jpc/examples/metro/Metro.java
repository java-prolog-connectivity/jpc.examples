package org.jpc.examples.metro;

import static java.util.Arrays.asList;
import static org.jpc.LogicEngineProvider.logicEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.TermAdaptable;
import org.jpc.term.Query;
import org.jpc.term.AbstractTerm;
import org.jpc.term.Variable;


public class Metro implements IMetro, TermAdaptable {


	
	@Override
	public String toString() {return "metro";}
	
	public AbstractTerm asTerm() {
		return new Atom("metro");
	}
	
	public static String LOADER = "logic_lib/examples/metro/load_all";
	
	public static boolean loadAll() {
		Term logtalkLoadTerm = new Compound("logtalk_load", asList(new Atom(LOADER)));
		Query query = logicEngine.createQuery(logtalkLoadTerm);
		return query.hasSolution();
	}

	@Override
	public List<ILine> lines() {
		String lineVarName = "Line";
		AbstractTerm message = new Compound("line", asList(new Variable(lineVarName)));
		Term objectMessage = new Compound("::", asList((TermAdaptable)this, message));
		Query query = logicEngine.createQuery(objectMessage);
		List<Map<String, Term>> solutions = query.allSolutions();
		List<ILine> lines = new ArrayList<ILine>();
		for(Map<String, Term> solution : solutions) {
			Term term = new Compound("line", asList(solution.get(lineVarName)));
			lines.add(Line.create(term));
		}
		return lines;
	}

	@Override
	public ILine line(String name) {
		ILine line = null;
		AbstractTerm message = new Compound("line", asList(new Atom(name)));
		Term objectMessage = new Compound("::", asList(asTerm(), message));
		Query query = logicEngine.createQuery(objectMessage);
		if(query.hasSolution())
			line = Line.create(message);
		return line;
	}
	
}
