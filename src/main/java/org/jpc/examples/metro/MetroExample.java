package org.jpc.examples.metro;

import static java.util.Arrays.asList;
import static org.jpc.engine.prolog.PrologEngines.getPrologEngine;

import org.jpc.engine.logtalk.LogtalkConstants;
import org.jpc.examples.metro.model.MetroFactory;
import org.jpc.examples.metro.model.llapi.MetroLLApi;
import org.jpc.query.Query;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.util.engine.PrologResourceLoader;

public class MetroExample {
	
	public static String LOADER_FILE = "org/jpc/examples/metro/load_all"; //the file extension is optional for Prolog or Logtalk resources
	
	public static boolean loadAll() {
		return new PrologResourceLoader(getPrologEngine(MetroExample.class)).logtalkLoad(LOADER_FILE);
//		Term logtalkLoadTerm = new Compound("logtalk_load", asList(new Atom(LOADER_FILE)));
//		Query query = getPrologEngine().createQuery(logtalkLoadTerm);
//		return query.hasSolution();
	}

	public static void importFromRawDataFile() {
		new MetroSaltLoader(getPrologEngine(MetroExample.class)).load();
	}

	public static void importFromPrologFile() {
		new MetroPrologFileLoader(getPrologEngine(MetroExample.class)).load();
	}
	
	public static void removeData() {
		Term message = new Atom("remove_all");
		Term goal = new Compound(LogtalkConstants.LOGTALK_OPERATOR, asList(new Atom(MetroLLApi.METRO_ATOM_NAME), message));
		Query query = getPrologEngine(MetroExample.class).query(goal);
		query.oneSolution();
	}
	
	private static MetroFactory defaultMetroFatory;
	
	public static MetroFactory getFactory() {
		return defaultMetroFatory;
	}
	
	public static void setFactory(MetroFactory factory) {
		defaultMetroFatory = factory;
	}
	
}
