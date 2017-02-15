package org.jpc.examples.metro.model.llapi;

import static java.util.Arrays.asList;
import static org.jpc.engine.prolog.PrologEngines.getPrologEngine;
import static org.jpc.term.Var.dontCare;

import java.util.ArrayList;
import java.util.List;

import org.jpc.engine.logtalk.LogtalkConstants;
import org.jpc.engine.prolog.PrologEngine;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Station;
import org.jpc.query.Query;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.ListTerm;
import org.jpc.term.Term;
import org.jpc.term.Var;

public class StationLLApi implements Station {
	
	public static final String STATION_FUNCTOR_NAME = "station";
	
	public static StationLLApi create(Term stationTerm) {
		return new StationLLApi(((Atom)stationTerm.arg(1)).getName());
	}
	
	
	private final String name;
	private final PrologEngine prologEngine;
	
	public StationLLApi(String name) {
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
		return new Compound(STATION_FUNCTOR_NAME, asList(new Atom(getName())));
	}
	
	@Override
	public boolean connected(Station station) {
		Term message = new Compound("connected", asList(((StationLLApi)station).asTerm()));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		return query.hasSolution();
	}

	@Override
	public long numberConnections() {
		Term message = new Compound("connected", asList(dontCare()));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		return query.numberOfSolutions();
	}

	@Override
	public Station connected(Line line) {
		String stationVarName = "Station";
		Term message = new Compound("connected", asList(new Var(stationVarName), ((LineLLApi)line).asTerm()));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		Term stationTerm = query.oneSolutionOrThrow().get(stationVarName);
		return create(stationTerm);
	}

	@Override
	public List<Station> connected() {
		String stationVarName = "Station";
		Term message = new Compound("connected", asList(new Var(stationVarName)));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		List<Station> stations = new ArrayList<>();
		while(query.hasNext()) {
			Term stationTerm = query.next().get(stationVarName);
			stations.add(create(stationTerm));
		}
		return stations;
	}

	@Override
	public boolean nearby(Station station) {
		Term message = new Compound("nearby", asList(((StationLLApi)station).asTerm()));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		return query.hasSolution();
	}

	@Override
	public long numberNearbyStations() {
		Term message = new Compound("nearby", asList(dontCare()));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		return query.numberOfSolutions();
	}

	@Override
	public List<Station> nearby() {
		String stationVarName = "Station";
		Term message = new Compound("nearby", asList(new Var(stationVarName)));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		List<Station> stations = new ArrayList<>();
		while(query.hasNext()) {
			Term stationTerm = query.next().get(stationVarName);
			stations.add(create(stationTerm));
		}
		return stations;
	}

	@Override
	public boolean reachable(Station station) {
		Term message = new Compound("reachable", asList(((StationLLApi)station).asTerm()));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		return query.hasSolution();
	}

	@Override
	public long numberReachableStations() {
		Term message = new Compound("reachable", asList(dontCare()));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		return query.numberOfSolutions();
	}

	@Override
	public List<Station> intermediateStations(Station station) {
		String stationsVarName = "Stations";
		Term message = new Compound("reachable", asList(((StationLLApi)station).asTerm(), new Var(stationsVarName)));
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(asTerm(), message));
		Query query = prologEngine.query(goal);
		Term stationsList = query.oneSolutionOrThrow().get(stationsVarName);
		ListTerm listTerm = stationsList.asList();
		List<Station> stations = new ArrayList<>();
		for(Term stationTerm : listTerm) {
			stations.add(create(stationTerm));
		}
		return stations;
	}

}

