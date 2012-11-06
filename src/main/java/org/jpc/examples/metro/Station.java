package org.jpc.examples.metro;

import static java.util.Arrays.asList;
import static org.jpc.LogicEngineProvider.logicEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.TermAdaptable;
import org.jpc.term.Query;
import org.jpc.term.Term;
import org.jpc.term.Variable;
import org.jpc.util.LogicUtil;
import static org.jpc.term.Variable.ANONYMOUS_VAR;

public class Station implements IStation, TermAdaptable {

	private String name;
	
	public Station(String name) {
		this.name = name;
	}

	//@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {return name;}
	
	public Term asTerm() {
		return new Compound("station", asList(new Atom(name)));
	}
	
	public static IStation create(Term term) {
		Compound stationTerm = (Compound)term;
		String lineName = ((Atom)stationTerm.arg(1)).name();
		return new Station(lineName);
	}


	public boolean connected(IStation station) {
		Term message = new Compound("connected", asList((TermAdaptable)station));
		Term objectMessage = new Compound("::", asList((TermAdaptable)this, message));
		Query query = logicEngine.createQuery(objectMessage);
		return query.hasSolution();
	}


	public long numberConnections() {
		Term message = new Compound("connected", asList(ANONYMOUS_VAR));
		Term objectMessage = new Compound("::", asList((TermAdaptable)this, message));
		Query query = logicEngine.createQuery(objectMessage);
		return query.numberOfSolutions();
	}


	public IStation connected(ILine line) {
		IStation connectedStation = null;
		String stationVarName = "Station";
		Term message = new Compound("connected", asList(new Variable(stationVarName), (TermAdaptable)line));
		Term objectMessage = new Compound("::", asList((TermAdaptable)this, message));
		Query query = logicEngine.createQuery(objectMessage);
		Map<String, Term> solution = query.oneSolution();
		if(solution != null) {
			Term term = solution.get(stationVarName);
			connectedStation = create(term);
		}
		return connectedStation;
	}


	public List<IStation> connected() {
		String stationVarName = "Station";
		Term message = new Compound("connected", asList(new Variable(stationVarName)));
		Term objectMessage = new Compound("::", asList((TermAdaptable)this, message));
		Query query = logicEngine.createQuery(objectMessage);
		List<Map<String, Term>> solutions = query.allSolutions();
		List<IStation> stations = new ArrayList<IStation>();
		for(Map<String, Term> solution : solutions) {
			Term term = solution.get(stationVarName);
			stations.add(create(term));
		}
		return stations;
	}


	public boolean nearby(IStation station) {
		Term message = new Compound("nearby", asList((TermAdaptable)station));
		Term objectMessage = new Compound("::", asList(asTerm(), message));
		Query query = logicEngine.createQuery(objectMessage);
		return query.hasSolution();
	}


	public long numberNearbyStations() {
		Term message = new Compound("nearby", asList(ANONYMOUS_VAR));
		Term objectMessage = new Compound("::", asList(asTerm(), message));
		Query query = logicEngine.createQuery(objectMessage);
		return query.numberOfSolutions();
	}


	public List<IStation> nearby() {
		String stationVarName = "Station";
		Term message = new Compound("nearby", asList(new Variable(stationVarName)));
		Term objectMessage = new Compound("::", asList((TermAdaptable)this, message));
		Query query = logicEngine.createQuery(objectMessage);
		List<Map<String, Term>> solutions = query.allSolutions();
		List<IStation> stations = new ArrayList<IStation>();
		for(Map<String, Term> solution : solutions) {
			Term term = solution.get(stationVarName);
			stations.add(create(term));
		}
		return stations;
	}


	public boolean reachable(IStation station) {
		Term message = new Compound("reachable", asList((TermAdaptable)station));
		Term objectMessage = new Compound("::", asList(asTerm(), message));
		Query query = logicEngine.createQuery(objectMessage);
		return query.hasSolution();
	}


	public long numberReachableStations() {
		Term message = new Compound("reachable", asList(ANONYMOUS_VAR));
		Term objectMessage = new Compound("::", asList(asTerm(), message));
		Query query = logicEngine.createQuery(objectMessage);
		return query.numberOfSolutions();
	}


	public List<IStation> intermediateStations(IStation station) {
		List<IStation> intermediateStations = null;
		String stationsVarName = "Stations";
		Term message = new Compound("reachable", asList((TermAdaptable)station, new Variable(stationsVarName)));
		Term objectMessage = new Compound("::", asList(asTerm(), message));
		Query query = logicEngine.createQuery(objectMessage);
		Map<String, Term> solution = query.oneSolution();
		if(solution != null) {
			Term solutionTerm = solution.get(stationsVarName);
			List<Term> terms = LogicUtil.listToTerms(solutionTerm);
			List<IStation> stations = new ArrayList<IStation>();
			for(Term term : terms) {
				stations.add(create(term));
			}
			intermediateStations = stations;
		}
		return intermediateStations;
	}


}
