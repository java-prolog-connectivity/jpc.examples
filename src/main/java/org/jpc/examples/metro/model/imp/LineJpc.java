package org.jpc.examples.metro.model.imp;

import static java.util.Arrays.asList;
import static org.jpc.engine.provider.PrologEngineProviderManager.getPrologEngine;
import static org.jpc.examples.metro.model.imp.MetroJpc.jpcContext;
import static org.jpc.term.Variable.ANONYMOUS_VAR;

import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Station;
import org.jpc.query.Query;
import org.jpc.term.Compound;
import org.jpc.term.Term;

public class LineJpc implements Line {

	private String name;
	
	public LineJpc(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {return name;}

	private LogtalkObject asLogtalkObject() {
		return new LogtalkObject(this, getPrologEngine(), jpcContext);
	}
	
	public boolean connects(Station s1, Station s2) {
		Term message = jpcContext.toTerm("connects", asList(s1,s2));
		Query query = asLogtalkObject().perform(message);
		return query.hasSolution();
	}

	public long segments() {
		Term message = new Compound("connects", asList(ANONYMOUS_VAR, ANONYMOUS_VAR));
		Query query = asLogtalkObject().perform(message);
		return query.numberOfSolutions();
	}
	
}
