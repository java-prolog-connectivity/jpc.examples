package org.jpc.examples.osm;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.jpc.engine.prolog.PrologEngine;
import org.jpc.util.PrologLoader;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class OsmDataLoader extends PrologLoader {

	public static String DEFAULT_DATA_FILE = "org/jpc/examples/osm/brussels_center_filtered.osm";
	
	public OsmDataLoader(PrologEngine logicEngine) {
		super(logicEngine);
	}

	@Override
	public void load() {
		File resourceFile = new File(getClass().getClassLoader().getResource(DEFAULT_DATA_FILE).getFile());
		load(resourceFile);
	}

	public void load(File resourceFile) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			final Set<String> names = new HashSet<>();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler saxHandler = new DefaultHandler() {
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					names.add(qName);
				}
			};
			saxParser.parse(resourceFile, saxHandler);
			for(String s:names) {
				System.out.println(s);
			}
		} catch (IOException | ParserConfigurationException | SAXException e) {
			throw new RuntimeException(e);
		}
	}

}