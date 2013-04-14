package org.jpc.examples.metro;

import static java.util.Arrays.asList;
import static org.jpc.examples.metro.model.jpcconverters.LineConverter.LINE_FUNCTOR;
import static org.jpc.examples.metro.model.jpcconverters.StationConverter.STATION_FUNCTOR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.engine.prolog.PrologEngine;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;

/**
 * The data loader for the metro example
 * @author sergioc
 *
 */
public class MetroDataLoader {

	private PrologEngine prologEngine;
	public static final String METRO_LINE_MARKER = "!";
	public static String DEFAULT_DATA_FILE = "org/jpc/examples/metro/data.txt";
	
	
	public MetroDataLoader(PrologEngine prologEngine) {
		this.prologEngine = prologEngine;
	}

	public void load() {
		File resourceFile = new File(getClass().getClassLoader().getResource(DEFAULT_DATA_FILE).getFile());
		load(resourceFile);
	}
	
	
	public void load(File resourceFile) {
		try(BufferedReader br = new BufferedReader(new FileReader(resourceFile));) {
			String line = br.readLine();
			String lineName = null;
			while(line != null) {
				line = line.trim();
				if(!line.isEmpty()) {
					if(line.startsWith(METRO_LINE_MARKER)) {
						lineName = line.substring(METRO_LINE_MARKER.length());
					} else {
						String[] stationNames = line.split(",");
						String stationName1 = stationNames[0];
						String stationName2 = stationNames[1];
						loadConnected(stationName1, stationName2, lineName);
					}
				}
				line = br.readLine();
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void loadConnected(String stationName1, String stationName2, String lineName) {
		Term station1Term = new Compound(STATION_FUNCTOR, 
				asList(new Atom(stationName1)));
		Term station2Term = new Compound(STATION_FUNCTOR, 
				asList(new Atom(stationName2)));
		Term lineTerm = new Compound(LINE_FUNCTOR, 
				asList(new Atom(lineName)));
		LogtalkObject logtalkObject = new LogtalkObject(lineTerm, prologEngine);
		Term message = new Compound("add_connection", 
				asList(station1Term, station2Term));
		logtalkObject.perform(message).hasSolution();
	}
	
	
}
