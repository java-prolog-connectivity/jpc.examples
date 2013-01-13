package org.jpc.examples.metro.imp;

import static java.util.Arrays.asList;
import static org.jpc.term.Variable.ANONYMOUS_VAR;
import static org.jpc.util.concurrent.ThreadLocalPrologEngine.getPrologEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jpc.converter.fromterm.TermToObjectConverter;
import org.jpc.converter.fromterm.fromlistterm.ListTermToListConverter;
import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Station;
import org.jpc.query.Query;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.Variable;

public class StationImp implements Station {

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
	
	@Override
	public Term asTerm() {
		return new Compound(STATION_FUNCTOR, asList(new Atom(name)));
	}

	public boolean connected(Station station) {
		Term message = new Compound("connected", asList(station));
		Query query = new LogtalkObject(this, getPrologEngine()).perform(message);
		return query.hasSolution();
	}


	public long numberConnections() {
		Term message = new Compound("connected", asList(ANONYMOUS_VAR));
		Query query = new LogtalkObject(this, getPrologEngine()).perform(message);
		return query.numberOfSolutions();
	}


	public Station connected(Line line) {
		String stationVarName = "Station";
		Term message = new Compound("connected", asList(new Variable(stationVarName), line));
		Query query = new LogtalkObject(this, getPrologEngine()).perform(message);
		return query.select(stationVarName).adapt(new TermToStationConverter()).oneSolution();
	}


	public List<Station> connected() {
		String stationVarName = "Station";
		Term message = new Compound("connected", asList(new Variable(stationVarName)));
		Query query = new LogtalkObject(this, getPrologEngine()).perform(message);
		return query.select(stationVarName).adapt(new TermToStationConverter()).allSolutions();
	}


	public boolean nearby(Station station) {
		Term message = new Compound("nearby", asList(station));
		Query query = new LogtalkObject(this, getPrologEngine()).perform(message);
		return query.hasSolution();
	}


	public long numberNearbyStations() {
		Term message = new Compound("nearby", asList(ANONYMOUS_VAR));
		Query query = new LogtalkObject(this, getPrologEngine()).perform(message);
		return query.numberOfSolutions();
	}


	public List<Station> nearby() {
		String stationVarName = "Station";
		Term message = new Compound("nearby", asList(new Variable(stationVarName)));
		Query query = new LogtalkObject(this, getPrologEngine()).perform(message);
		return query.select(stationVarName).adapt(new TermToStationConverter()).allSolutions();
	}


	public boolean reachable(Station station) {
		Term message = new Compound("reachable", asList(station));
		Query query = new LogtalkObject(this, getPrologEngine()).perform(message);
		return query.hasSolution();
	}


	public long numberReachableStations() {
		Term message = new Compound("reachable", asList(ANONYMOUS_VAR));
		Query query = new LogtalkObject(this, getPrologEngine()).perform(message);
		return query.numberOfSolutions();
	}


	public List<Station> intermediateStations(Station station) {
		String stationsVarName = "Stations";
		Term message = new Compound("reachable", asList(station, new Variable(stationsVarName)));
		Query query = new LogtalkObject(this, getPrologEngine()).perform(message);
		return (List<Station>) query.select(stationsVarName).adapt(new ListTermToListConverter(new TermToStationConverter())).oneSolution();
	}


}
