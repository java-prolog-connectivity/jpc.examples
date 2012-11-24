package org.jpc.examples.metro;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Station;
import org.junit.Test;

public class TestLine extends MetroExampleTest  {
	

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
