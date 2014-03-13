package org.jpc.examples.metro.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Station;
import org.junit.Test;

public class LineTest extends AbstractMetroTest  {
	

	@Test
	public void testConnects() {
		Station station1 = station("bond_street");
		Station station2 = station("oxford_circus");
		Station station3 = station("charing_cross");
		Line line1 = line("central");
		assertTrue(line1.connects(station1, station2));
		assertFalse(line1.connects(station1, station3));
	}

	@Test
	public void testNumberSegments() {
		Line line1 = line("central");
		assertEquals(line1.segments(), 2);
		//System.out.println("Number of segments of line " + line1 + ": " + line1.segments());
		
		Line line2 = line("unexisting_line");
		assertEquals(line2.segments(), 0);
	}

}
