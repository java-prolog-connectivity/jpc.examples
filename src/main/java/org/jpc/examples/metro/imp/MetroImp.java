package org.jpc.examples.metro.imp;

import static java.util.Arrays.asList;
import static org.jpc.util.ThreadLocalLogicEngine.getLogicEngine;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Metro;
import org.jpc.term.AbstractTerm;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Query;
import org.jpc.term.Term;
import org.jpc.term.TermConvertable;
import org.jpc.term.Variable;
import org.jpc.util.LogicResourceLoader;
import org.reflections.util.ClasspathHelper;


public class MetroImp implements Metro, TermConvertable {

	@Override
	public String toString() {return "metro";}
	
	public AbstractTerm asTerm() {
		return new Atom("metro");
	}
	
	public static String LOADER = "org/jpc/examples/metro/load_all";
	
	
	public static void main(String[] args) {
		
		Set<URL> urls = ClasspathHelper.forPackage("logic_lib/examples/metro/load_all.lgt");
		System.out.println(urls);
		urls = ClasspathHelper.forPackage("logic_lib.examples.metro.load_all.lgt");
		System.out.println(urls);
		
		URL url = Thread.currentThread().getContextClassLoader().getResource("logic_lib/examples/metro/load_all.lgt");
		System.out.println(url);
	}
	
	public static boolean loadAll() {
		return new LogicResourceLoader(getLogicEngine()).logtalkLoad(LOADER);
//		Term logtalkLoadTerm = new Compound("logtalk_load", asList(new Atom(LOADER)));
//		Query query = getLogicEngine().createQuery(logtalkLoadTerm);
//		return query.hasSolution();
	}

	@Override
	public List<Line> lines() {
		String lineVarName = "Line";
		AbstractTerm message = new Compound("line", asList(new Variable(lineVarName)));
		Term objectMessage = new Compound("::", asList((TermConvertable)this, message));
		Query query = getLogicEngine().createQuery(objectMessage);
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
		Term objectMessage = new Compound("::", asList(asTerm(), message));
		Query query = getLogicEngine().createQuery(objectMessage);
		if(query.hasSolution())
			line = LineImp.create(message);
		return line;
	}
	
}
