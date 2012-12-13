package org.jpc.examples.metro;

import static org.jpc.util.ThreadLocalLogicEngine.getLogicEngine;

import org.jpc.util.LogicResourceLoader;

public class MetroExample {
	
	public static String LOADER_FILE = "org/jpc/examples/metro/load_all"; //the file extension is optional for Prolog or Logtalk resources
	
	public static boolean loadAll() {
		return new LogicResourceLoader(getLogicEngine()).logtalkLoad(LOADER_FILE);
//		Term logtalkLoadTerm = new Compound("logtalk_load", asList(new Atom(LOADER)));
//		Query query = getLogicEngine().createQuery(logtalkLoadTerm);
//		return query.hasSolution();
	}

	public static void importData() {
		new MetroDataLoader(getLogicEngine()).load();
	}

}
