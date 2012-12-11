package org.jpc.examples.metro;

import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jpc.engine.logtalk.LogtalkConstants;
import org.jpc.engine.logtalk.LogtalkObject;
import org.jpc.engine.prolog.PrologEngine;
import org.jpc.examples.metro.imp.LineImp;
import org.jpc.examples.metro.imp.MetroImp;
import org.jpc.examples.metro.imp.StationImp;
import org.jpc.salt.PrologWriter;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;

public class DataLoader {

	protected final String METRO_LINE_MARKER = "!";
	
	protected File resourceFile;
	protected PrologEngine logicEngine;
	private PrologWriter writer;
	
	public DataLoader(File resourceFile, PrologEngine logicEngine) {
		this.resourceFile = resourceFile;
		this.logicEngine = logicEngine;
		writer = new PrologWriter(logicEngine);
	}

	public void loadData() {
		try(BufferedReader br = new BufferedReader(new FileReader(resourceFile));) {
			String metroLineName = nextMetroLine(br);
			while(metroLineName != null) {
				String connectionEntry = nextConnectionEntry(br);
				while(connectionEntry != null) {
					String[] metroStationNames = connectionEntry.split(",");
					loadConnected(metroStationNames[0], metroStationNames[1], metroLineName);
					connectionEntry = nextConnectionEntry(br);
				}
				metroLineName = nextMetroLine(br);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String nextMetroLine(BufferedReader reader) {
		try {
			String line = reader.readLine();
			while(line != null && !line.startsWith(METRO_LINE_MARKER)) {
				line = reader.readLine();
			}
			if(line != null) {
				line = line.trim().substring(METRO_LINE_MARKER.length());
			}
			return line;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private String nextConnectionEntry(BufferedReader reader) {
		try {
			String line = reader.readLine();
			if(line != null) {
				line = line.trim();
				if(line.isEmpty())
					line = null;
			}
			return line;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	private void loadConnected2(String station1, String station2, String line) {
		Term logtalkObjectTerm = new Atom(MetroImp.METRO_FUNCTOR);
		Term station1Term = new Compound(StationImp.STATION_FUNCTOR, 
				asList(new Atom(station1)));
		Term station2Term = new Compound(StationImp.STATION_FUNCTOR, 
				asList(new Atom(station2)));
		Term lineTerm = new Compound(LineImp.LINE_FUNCTOR, 
				asList(new Atom(line)));
		Term message = new Compound("connected", 
				asList(station1Term, station2Term, lineTerm));
		LogtalkObject logtalkObject = new LogtalkObject(logicEngine, logtalkObjectTerm);
		logtalkObject.assertz(message);
	}
	
	
	private void loadConnected(String station1, String station2, String line) {
		writer.startLogtalkObjectClause();
		writer.startAtom(MetroImp.METRO_FUNCTOR);
		writeConnected(station1, station2, line);
	}

	private void writeConnected(String station1, String station2, String line) {
		writer.startCompound().startAtom("connected");
        writeStation(station1);
        writeStation(station2);
        writeLine(line);
        writer.endCompound();
	}
	

	private void writeStation(String stationName) {
		writer.startCompound().startAtom(StationImp.STATION_FUNCTOR);
		writer.startAtom(stationName);
		writer.endCompound();
	}
	
	private void writeLine(String lineName) {
		writer.startCompound().startAtom(LineImp.LINE_FUNCTOR);
		writer.startAtom(lineName);
		writer.endCompound();
	}
}
