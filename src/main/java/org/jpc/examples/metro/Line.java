package org.jpc.examples.metro;

import static java.util.Arrays.asList;
import static org.jpc.LogicEngineProvider.logicEngine;
import static org.jpc.term.Variable.ANONYMOUS_VAR;

import java.util.Arrays;

import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.TermAdaptable;
import org.jpc.term.Query;
import org.jpc.term.AbstractTerm;

public class Line implements ILine, TermAdaptable {

	private String name;
	
	public Line(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {return name;}
	
	public AbstractTerm asTerm() {
		return new Compound("line", Arrays.asList(new Atom(name)));
	}
	
	public static ILine create(Term term) {
		Compound lineTerm = (Compound)term;
		String lineName = ((Atom)lineTerm.arg(1)).name();
		return new Line(lineName);
	}


	public boolean connects(IStation s1, IStation s2) {
		AbstractTerm message = new Compound("connects", asList((TermAdaptable)s1,(TermAdaptable)s2));
		Term objectMessage = new Compound("::", asList(this, message));
		Query query = logicEngine.createQuery(objectMessage);
		return query.hasSolution();
	}


	public long segments() {
		AbstractTerm message = new Compound("connects", asList(ANONYMOUS_VAR, ANONYMOUS_VAR));
		Term objectMessage = new Compound("::", asList(this, message));
		Query query = logicEngine.createQuery(objectMessage);
		return query.numberOfSolutions();
	}
	
}
