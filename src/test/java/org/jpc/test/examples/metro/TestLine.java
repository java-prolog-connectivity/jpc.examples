package org.jpc.test.examples.metro;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.jpc.examples.metro.ILine;
import org.jpc.examples.metro.IStation;
import org.junit.Test;

public class TestLine extends AbstractMetroTest  {
	

	@Test
	public void testConnects() {
		IStation station1 = station("bond_street");
		IStation station2 = station("oxford_circus");
		IStation station3 = station("charing_cross");
		ILine line1 = line("central");
		assertTrue(line1.connects(station1, station2));
		assertFalse(line1.connects(station1, station3));
	}

	@Test
	public void testNumberSegments() {
		ILine line1 = line("central");
		assertEquals(line1.segments(), 2);
		//System.out.println("Number of segments of line " + line1 + ": " + line1.segments());
		
		ILine line2 = line("unexisting_line");
		assertEquals(line2.segments(), 0);
	}

}
