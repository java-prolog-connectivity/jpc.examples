package org.jpc.examples.metro.model.imp;

import static java.util.Arrays.asList;
import static org.jpc.engine.provider.PrologEngineProviderManager.getPrologEngine;
import static org.jpc.examples.metro.model.imp.MetroJpc.jpcContext;
import static org.jpc.term.Var.ANONYMOUS_VAR;

import java.util.List;

import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Station;
import org.jpc.query.Query;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.Var;

public class StationJpc implements Station {
	
	private String name;
	
	public StationJpc(String name) {
		this.name = name;
	}

	//@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {return name;}

	private LogtalkObject asLogtalkObject() {
		return new LogtalkObject(this, getPrologEngine(), jpcContext);
	}
	
	public boolean connected(Station station) {
		Term message = jpcContext.toCompound("connected", asList(station));
		return asLogtalkObject().perform(message).hasSolution();
	}


	public long numberConnections() {
		Term message = new Compound("connected", asList(ANONYMOUS_VAR));
		return asLogtalkObject().perform(message).numberOfSolutions();
	}


	
//	public Station connected(Line line) {
//		String stationVarName = "Station";
//		Term message = jpcContext.compound("connected", asList(new Variable(stationVarName), line));
//		Query query = asLogtalkObject().perform(message);
//		return query.<Station>selectObject(stationVarName).oneSolution();
//	}

	/**
	 * Version of the connected(Line) method as it was shown in the WASDeTT paper.
	 */
	public Station connected(Line line) {
		String stationVarName = "Station";
		Term message = jpcContext.toCompound("connected", asList(new Var(stationVarName), line));
		Term objectMessage = jpcContext.toCompound("::", asList(this, message));
		Query query = getPrologEngine().query(objectMessage, jpcContext);
		return query.<Station>selectObject(stationVarName).oneSolutionOrThrow();
	}

	public List<Station> connected() {
		String stationVarName = "Station";
		Term message = new Compound("connected", asList(new Var(stationVarName)));
		Query query = asLogtalkObject().perform(message);
		return query.<Station>selectObject(stationVarName).allSolutions();
	}


	public boolean nearby(Station station) {
		Term message = jpcContext.toCompound("nearby", asList(station));
		return asLogtalkObject().perform(message).hasSolution();
	}


	public long numberNearbyStations() {
		Term message = new Compound("nearby", asList(ANONYMOUS_VAR));
		Query query = asLogtalkObject().perform(message);
		return query.numberOfSolutions();
	}


	public List<Station> nearby() {
		String stationVarName = "Station";
		Term message = new Compound("nearby", asList(new Var(stationVarName)));
		Query query = asLogtalkObject().perform(message);
		return query.<Station>selectObject(stationVarName).allSolutions();
	}


	public boolean reachable(Station station) {
		Term message = jpcContext.toCompound("reachable", asList(station));
		return asLogtalkObject().perform(message).hasSolution();
	}


	public long numberReachableStations() {
		Term message = new Compound("reachable", asList(ANONYMOUS_VAR));
		return asLogtalkObject().perform(message).numberOfSolutions();
	}


	public List<Station> intermediateStations(Station station) {
		String stationsVarName = "Stations";
		Term message = jpcContext.toCompound("reachable", asList(station, new Var(stationsVarName)));
		Query query = asLogtalkObject().perform(message);
		return query.<List<Station>>selectObject(stationsVarName).oneSolutionOrThrow();
	}

}
