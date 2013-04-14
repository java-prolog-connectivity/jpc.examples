package org.jpc.examples.metro;

import static org.jpc.engine.provider.PrologEngineProviderManager.getPrologEngine;

import org.jpc.util.PrologResourceLoader;

public class MetroExample {
	
	public static String LOADER_FILE = "org/jpc/examples/metro/load_all"; //the file extension is optional for Prolog or Logtalk resources
	
	public static boolean loadAll() {
		return new PrologResourceLoader(getPrologEngine()).logtalkLoad(LOADER_FILE);
//		Term logtalkLoadTerm = new Compound("logtalk_load", asList(new Atom(LOADER_FILE)));
//		Query query = getPrologEngine().createQuery(logtalkLoadTerm);
//		return query.hasSolution();
	}

	public static void importData() {
		new SaltMetroDataLoader(getPrologEngine()).load();
	}

}
