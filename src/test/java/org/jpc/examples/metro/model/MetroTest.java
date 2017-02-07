package org.jpc.examples.metro.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

public class MetroTest extends AbstractMetroTest {


	@Test
	public void testAllLines() {
		Metro metro = metro();
		List<Line> lines = metro.lines();
		assertNotNull(lines);
		assertEquals(6, lines.size());
		
//		System.out.println("Number of lines: " + lines.size());
//		System.out.print("Lines: ");
//		for(ILine line : lines) {
//			System.out.print(line + " ");
//		}
//		System.out.println();
		
	}
	
	@Test
	public void testIsLine() {
		Metro metro = metro();
		Line line = metro.line("central");
		assertNotNull(line);
		//System.out.println("Line: " + line);
		
		try {
			line = metro.line("line1");
			fail();
		} catch(NoSuchElementException e){}
	}
	
}
