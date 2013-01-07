package org.jpc.examples.metro.imp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jpc.engine.prolog.PrologEngine;
import org.jpc.util.salt.SaltPrologLoader;

import static org.jpc.examples.metro.imp.MetroDataLoader.*;

/**
 * An alternative (shorter) implementation for a data loader using the SALT library
 * @author sergioc
 *
 */
public class SaltMetroDataLoader extends SaltPrologLoader {

	public SaltMetroDataLoader(PrologEngine logicEngine) {
		super(logicEngine);
	}

	public void load() {
		File resourceFile = new File(getClass().getClassLoader().getResource(DEFAULT_DATA_FILE).getFile());
		load(resourceFile);
	}
	
	public void load(File resourceFile) {
		try(BufferedReader br = new BufferedReader(new FileReader(resourceFile));) {
			String line = br.readLine();
			writer.followingDirectives();
			while(line != null) {
				line = line.trim();
				if(!line.isEmpty()) {
					if(line.startsWith(METRO_LINE_MARKER)) {
						String lineName = line.substring(METRO_LINE_MARKER.length());
						writer.startLogtalkObjectContext();
						writer.startCompound().startAtom(LineImp.LINE_FUNCTOR).startAtom(lineName).endCompound();
					} else {
						String[] stationNames = line.split(",");
						writer.startCompound().startAtom("add_connection");
						for(String stationName : stationNames) {
							writer.startCompound().startAtom(StationImp.STATION_FUNCTOR).startAtom(stationName).endCompound();
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
