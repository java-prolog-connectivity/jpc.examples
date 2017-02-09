package org.jpc.examples.metro;

import static org.jpc.examples.metro.MetroRawDataLoader.DEFAULT_DATA_FILE;
import static org.jpc.examples.metro.MetroRawDataLoader.METRO_LINE_MARKER;
import static org.jpc.examples.metro.model.hlapi.converters.LineConverter.LINE_FUNCTOR_NAME;
import static org.jpc.examples.metro.model.hlapi.converters.StationConverter.STATION_FUNCTOR_NAME;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.jpc.engine.prolog.PrologEngine;
import org.jpc.util.salt.PrologContentHandler;
import org.jpc.util.termprocessor.PrologEngineWriter;

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
		load(getClass().getClassLoader().getResource(DEFAULT_DATA_FILE));
	}
	
	public void load(URL resourceUrl) {
		PrologContentHandler writer = new PrologContentHandler(new PrologEngineWriter(prologEngine));
		try(BufferedReader br = new BufferedReader(new InputStreamReader(resourceUrl.openStream()));) {
			String line = br.readLine();
			writer.followingDirectives();
			while (line != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					if (line.startsWith(METRO_LINE_MARKER)) {
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
