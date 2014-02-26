package org.jpc.examples.metro;

import static org.jpc.examples.metro.MetroRawDataLoader.DEFAULT_DATA_FILE;
import static org.jpc.examples.metro.MetroRawDataLoader.METRO_LINE_MARKER;
import static org.jpc.examples.metro.model.hlapi.converters.LineConverter.LINE_FUNCTOR_NAME;
import static org.jpc.examples.metro.model.hlapi.converters.StationConverter.STATION_FUNCTOR_NAME;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.jpc.engine.prolog.PrologEngine;
import org.jpc.salt.PrologEngineWriter;
import org.jpc.salt.PrologWriter;

/**
 * An alternative (shorter) implementation for a data loader using the SALT library
 * @author sergioc
 *
 */
public class MetroSaltLoader {

	private final PrologEngine prologEngine;
	
	public MetroSaltLoader(PrologEngine prologEngine) {
		this.prologEngine = prologEngine;
	}

	public void load() {
		File resourceFile = new File(getClass().getClassLoader().getResource(DEFAULT_DATA_FILE).getFile());
		load(resourceFile);
	}
	
	public void load(File resourceFile) {
		PrologWriter writer = new PrologEngineWriter(prologEngine);
		try(BufferedReader br = new BufferedReader(new FileReader(resourceFile));) {
			String line = br.readLine();
			writer.followingDirectives();
			while(line != null) {
				line = line.trim();
				if(!line.isEmpty()) {
					if(line.startsWith(METRO_LINE_MARKER)) {
						String lineName = line.substring(METRO_LINE_MARKER.length());
						writer.startLogtalkObjectContext();
						writer.startCompound().startAtom(LINE_FUNCTOR_NAME).startAtom(lineName).endCompound();
					} else {
						String[] stationNames = line.split(",");
						writer.startCompound().startAtom("add_connection");
						for(String stationName : stationNames) {
							writer.startCompound().startAtom(STATION_FUNCTOR_NAME).startAtom(stationName).endCompound();
						}
						writer.endCompound();
					}
				}
				line = br.readLine();
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
