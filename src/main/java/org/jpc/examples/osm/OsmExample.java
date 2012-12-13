package org.jpc.examples.osm;

import static org.jpc.util.ThreadLocalLogicEngine.getLogicEngine;

import org.jpc.util.LogicResourceLoader;

public class OsmExample {

	public static String LOADER_FILE = "org/jpc/examples/osm/load_all";
	
	public static boolean loadAll() {
		return new LogicResourceLoader(getLogicEngine()).logtalkLoad(LOADER_FILE);
	}
	
	public static void importData() {
		new OsmDataLoader(getLogicEngine()).load();
	}
	
}
