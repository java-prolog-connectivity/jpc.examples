package org.jpc.examples.metro.imp;

import static org.jpc.util.concurrent.ThreadLocalPrologEngine.getPrologEngine;

import org.jpc.util.LogicResourceLoader;

public class MetroExample {
	
	public static String LOADER_FILE = "org/jpc/examples/metro/load_all"; //the file extension is optional for Prolog or Logtalk resources
	
	public static boolean loadAll() {
		return new LogicResourceLoader(getPrologEngine()).logtalkLoad(LOADER_FILE);
//		Term logtalkLoadTerm = new Compound("logtalk_load", asList(new Atom(LOADER_FILE)));
//		Query query = getPrologEngine().createQuery(logtalkLoadTerm);
//		return query.hasSolution();
	}

	public static void importData() {
		new SaltMetroDataLoader(getPrologEngine()).load();
	}

}
