package org.jpc.examples.metro.model.hlapi;

import static java.util.Arrays.asList;
import static org.jpc.engine.provider.PrologEngineProviderManager.getPrologEngine;
import static org.jpc.examples.metro.model.hlapi.MetroHLApi.jpcContext;
import static org.jpc.term.Var.ANONYMOUS_VAR;

import java.util.List;

import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Station;
import org.jpc.query.Query;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.Var;

public class StationHLApi implements Station {
	
	private String name;
	
	public StationHLApi(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {return name;}

	
	private LogtalkObject<Compound> asLogtalkObject() {
		return new LogtalkObject<>(this, getPrologEngine(), jpcContext);
	}
	
	@Override
	public boolean connected(Station station) {
		Term message = jpcContext.toCompound("connected", asList(station));
		return asLogtalkObject().perform(message).hasSolution();
	}

	@Override
	public long numberConnections() {
		Term message = new Compound("connected", asList(ANONYMOUS_VAR));
		return asLogtalkObject().perform(message).numberOfSolutions();
	}

	@Override
	public Station connected(Line line) {
		String stationVarName = "Station";
		Term message = jpcContext.toCompound("connected", asList(new Var(stationVarName), line));
		Query query = asLogtalkObject().perform(message);
		return query.<Station>selectObject(stationVarName).oneSolutionOrThrow();
	}

	@Override
	public List<Station> connected() {
		String stationVarName = "Station";
		Term message = new Compound("connected", asList(new Var(stationVarName)));
		Query query = asLogtalkObject().perform(message);
		return query.<Station>selectObject(stationVarName).allSolutions();
	}

	@Override
	public boolean nearby(Station station) {
		Term message = jpcContext.toCompound("nearby", asList(station));
		return asLogtalkObject().perform(message).hasSolution();
	}

	@Override
	public long numberNearbyStations() {
		Term message = new Compound("nearby", asList(ANONYMOUS_VAR));
		Query query = asLogtalkObject().perform(message);
		return query.numberOfSolutions();
	}

	@Override
	public List<Station> nearby() {
		String stationVarName = "Station";
		Term message = new Compound("nearby", asList(new Var(stationVarName)));
		Query query = asLogtalkObject().perform(message);
		return query.<Station>selectObject(stationVarName).allSolutions();
	}

	@Override
	public boolean reachable(Station station) {
		Term message = jpcContext.toCompound("reachable", asList(station));
		return asLogtalkObject().perform(message).hasSolution();
	}

	@Override
	public long numberReachableStations() {
		Term message = new Compound("reachable", asList(ANONYMOUS_VAR));
		return asLogtalkObject().perform(message).numberOfSolutions();
	}

	@Override
	public List<Station> intermediateStations(Station station) {
		String stationsVarName = "Stations";
		Term message = jpcContext.toCompound("reachable", asList(station, new Var(stationsVarName)));
		Query query = asLogtalkObject().perform(message);
		return query.<List<Station>>selectObject(stationsVarName).oneSolutionOrThrow();
	}

}
