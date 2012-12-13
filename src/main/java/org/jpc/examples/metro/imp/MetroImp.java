package org.jpc.examples.metro.imp;

import static java.util.Arrays.asList;
import static org.jpc.util.ThreadLocalLogicEngine.getLogicEngine;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.engine.prolog.Query;
import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Metro;
import org.jpc.examples.metro.MetroDataLoader;
import org.jpc.term.AbstractTerm;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.TermConvertable;
import org.jpc.term.Variable;
import org.jpc.util.LogicResourceLoader;
import org.reflections.util.ClasspathHelper;


public class MetroImp implements Metro, TermConvertable {

	public static final String METRO_FUNCTOR = "metro";
	
	@Override
	public String toString() {return METRO_FUNCTOR;}
	
	public AbstractTerm asTerm() {
		return new Atom(METRO_FUNCTOR);
	}

	
	@Override
	public List<Line> lines() {
		String lineVarName = "Line";
		AbstractTerm message = new Compound("line", asList(new Variable(lineVarName)));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		List<Map<String, Term>> solutions = query.allSolutions();
		List<Line> lines = new ArrayList<Line>();
		for(Map<String, Term> solution : solutions) {
			Term term = new Compound("line", asList(solution.get(lineVarName)));
			lines.add(LineImp.create(term));
		}
		return lines;
	}

	@Override
	public Line line(String name) {
		Line line = null;
		AbstractTerm message = new Compound("line", asList(new Atom(name)));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		if(query.hasSolution())
			line = LineImp.create(message);
		return line;
	}
	
}
