package org.jpc.examples.metro.model.hlapi;

import static java.util.Arrays.asList;
import static org.jpc.examples.metro.model.hlapi.MetroHLApi.jpcContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.Station;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.junit.Test;

public class ConversionsTest {

	@Test
	public void testStationToTerm() {
		Station station = new StationHLApi("s");
		Term stationTerm = jpcContext.toTerm(station);
		assertEquals(new Compound("station", asList(new Atom("s"))), stationTerm);
	}
	
	@Test
	public void testTermToStation() {
		Term stationTerm = new Compound("station", asList(new Atom("s")));
		Station station = jpcContext.fromTerm(stationTerm);
		assertEquals("s", station.getName());
	}
	
	@Test
	public void testLineToTerm() {
		Line line = new LineHLApi("l");
		Term lineTerm = jpcContext.toTerm(line);
		assertEquals(new Compound("line", asList(new Atom("l"))), lineTerm);
	}
	
	@Test
	public void testTermToLine() {
		Term lineTerm = new Compound("line", asList(new Atom("l")));
		Line line = jpcContext.fromTerm(lineTerm);
		assertEquals("l", line.getName());
	}
	
	@Test
	public void testMetroToTerm() {
		Metro metro = new MetroHLApi();
		Term metroTerm = jpcContext.toTerm(metro);
		assertEquals(new Atom("metro"), metroTerm);
	}
	
	@Test
	public void testTermToMetro() {
		Term metroTerm = new Atom("metro");
		assertEquals("metro", jpcContext.fromTerm(metroTerm));
		assertTrue(jpcContext.fromTerm(metroTerm, Metro.class) instanceof Metro);
	}
	
}
