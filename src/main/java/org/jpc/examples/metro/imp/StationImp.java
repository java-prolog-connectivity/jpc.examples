package org.jpc.examples.metro.imp;

import static java.util.Arrays.asList;
import static org.jpc.term.Variable.ANONYMOUS_VAR;
import static org.jpc.util.ThreadLocalLogicEngine.getLogicEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.engine.prolog.Query;
import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Station;
import org.jpc.term.AbstractTerm;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.TermConvertable;
import org.jpc.term.Variable;

public class StationImp implements Station, TermConvertable {

	public static final String STATION_FUNCTOR = "station";
	
	private String name;
	
	public StationImp(String name) {
		this.name = name;
	}

	//@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {return name;}
	
	public AbstractTerm asTerm() {
		return new Compound(STATION_FUNCTOR, asList(new Atom(name)));
	}
	
	public static Station create(Term term) {
		Compound stationTerm = (Compound)term;
		String lineName = ((Atom)stationTerm.arg(1)).getName();
		return new StationImp(lineName);
	}


	public boolean connected(Station station) {
		AbstractTerm message = new Compound("connected", asList((TermConvertable)station));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		return query.hasSolution();
	}


	public long numberConnections() {
		AbstractTerm message = new Compound("connected", asList(ANONYMOUS_VAR));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		return query.numberOfSolutions();
	}


	public Station connected(Line line) {
		Station connectedStation = null;
		String stationVarName = "Station";
		Term message = new Compound("connected", asList(new Variable(stationVarName), (TermConvertable)line));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		Map<String, Term> solution = query.oneSolution();
		if(solution != null) {
			Term term = solution.get(stationVarName);
			connectedStation = create(term);
		}
		return connectedStation;
	}


	public List<Station> connected() {
		String stationVarName = "Station";
		Term message = new Compound("connected", asList(new Variable(stationVarName)));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		List<Map<String, Term>> solutions = query.allSolutions();
		List<Station> stations = new ArrayList<Station>();
		for(Map<String, Term> solution : solutions) {
			Term term = solution.get(stationVarName);
			stations.add(create(term));
		}
		return stations;
	}


	public boolean nearby(Station station) {
		AbstractTerm message = new Compound("nearby", asList((TermConvertable)station));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		return query.hasSolution();
	}


	public long numberNearbyStations() {
		AbstractTerm message = new Compound("nearby", asList(ANONYMOUS_VAR));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		return query.numberOfSolutions();
	}


	public List<Station> nearby() {
		String stationVarName = "Station";
		Term message = new Compound("nearby", asList(new Variable(stationVarName)));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		List<Map<String, Term>> solutions = query.allSolutions();
		List<Station> stations = new ArrayList<Station>();
		for(Map<String, Term> solution : solutions) {
			Term term = solution.get(stationVarName);
			stations.add(create(term));
		}
		return stations;
	}


	public boolean reachable(Station station) {
		Term message = new Compound("reachable", asList((TermConvertable)station));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		return query.hasSolution();
	}


	public long numberReachableStations() {
		Term message = new Compound("reachable", asList(ANONYMOUS_VAR));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		return query.numberOfSolutions();
	}


	public List<Station> intermediateStations(Station station) {
		List<Station> intermediateStations = null;
		String stationsVarName = "Stations";
		Term message = new Compound("reachable", asList((TermConvertable)station, new Variable(stationsVarName)));
		Query query = new LogtalkObject(getLogicEngine(), this).perform(message);
		Map<String, Term> solution = query.oneSolution();
		if(solution != null) {
			Term solutionTerm = solution.get(stationsVarName);
			List<Term> terms = solutionTerm.asList();
			List<Station> stations = new ArrayList<Station>();
			for(Term term : terms) {
				stations.add(create(term));
			}
			intermediateStations = stations;
		}
		return intermediateStations;
	}


}
