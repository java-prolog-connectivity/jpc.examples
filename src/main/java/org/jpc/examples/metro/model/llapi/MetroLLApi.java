package org.jpc.examples.metro.model.llapi;

import static java.util.Arrays.asList;
import static org.jpc.engine.provider.PrologEngineProviderManager.getPrologEngine;

import java.util.ArrayList;
import java.util.List;

import org.jpc.engine.logtalk.LogtalkConstants;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.hlapi.converters.LineConverter;
import org.jpc.query.Query;
import org.jpc.query.Solution;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.Var;

public class MetroLLApi implements Metro {

	public static final String METRO_ATOM_NAME = "metro";
	
	@Override
	public String toString() {return METRO_ATOM_NAME;}
	
	
	public Atom asTerm() {
		return new Atom(METRO_ATOM_NAME);
	}
	
	public List<Line> lines() {
		String lineVarName = "Line";
		Term message = new Compound(LineConverter.LINE_FUNCTOR_NAME, asList(new Var(lineVarName)));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = getPrologEngine().query(goal);
		List<Solution> solutions = query.allSolutions();
		List<Line> lines = new ArrayList<>();
		for(Solution solution : solutions) {
			Atom lineNameTerm = (Atom)solution.get(lineVarName);
			Line line = new LineLLApi(lineNameTerm.getName());
			lines.add(line);
		}
		return lines;
	}

	@Override
	public Line line(String name) {
		Term message = new Compound(LineConverter.LINE_FUNCTOR_NAME, asList(new Atom(name)));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = getPrologEngine().query(goal);
		query.oneSolutionOrThrow();
		return new LineLLApi(name);
	}
	
}
