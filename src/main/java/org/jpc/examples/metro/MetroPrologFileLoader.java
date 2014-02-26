package org.jpc.examples.metro;

import org.jpc.engine.prolog.PrologEngine;
import org.jpc.util.engine.PrologResourceLoader;

public class MetroPrologFileLoader {

	public static String DEFAULT_DATA_FILE = "org/jpc/examples/metro/data.lgt";

	private final PrologEngine prologEngine;
	
	public MetroPrologFileLoader(PrologEngine prologEngine) {
		this.prologEngine = prologEngine;
	}
	
	public void load() {
		new PrologResourceLoader(prologEngine).logtalkLoad(DEFAULT_DATA_FILE);
	}
	
}
