package org.jpc.examples.metro.model.hlapi;

import static java.util.Arrays.asList;
import static org.jpc.engine.prolog.PrologEngines.getPrologEngine;

import java.util.List;

import org.jpc.Jpc;
import org.jpc.JpcBuilder;
import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.engine.prolog.PrologEngine;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.hlapi.converters.LineConverter;
import org.jpc.examples.metro.model.hlapi.converters.MetroConverter;
import org.jpc.examples.metro.model.hlapi.converters.StationConverter;
import org.jpc.query.Query;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.Var;

public class MetroHLApi implements Metro {

	public static final Jpc jpcContext = JpcBuilder.create()
		.register(new MetroConverter())
		.register(new LineConverter())
		.register(new StationConverter()).build();

	
	private final PrologEngine prologEngine;
	
	public MetroHLApi() {
		prologEngine = getPrologEngine(getClass());
	}
	
	@Override
	public String toString() {return "metro";}
	
	
	private LogtalkObject<Atom> asLogtalkObject() {
		return new LogtalkObject<>(this, prologEngine, jpcContext);
	}
	
	@Override
	public List<Line> lines() {
		String lineVarName = "Line";
		Term message = new Compound(LineConverter.LINE_FUNCTOR_NAME, asList(new Var(lineVarName)));
		Query query = asLogtalkObject().perform(message);
		return query.<Line>selectObject().allSolutions();
	}

	@Override
	public Line line(String name) {
		Term message = new Compound(LineConverter.LINE_FUNCTOR_NAME, asList(new Atom(name)));
		return asLogtalkObject().perform(message).<Line>selectObject().oneSolutionOrThrow();
	}

}
