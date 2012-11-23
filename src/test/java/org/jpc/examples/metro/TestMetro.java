package org.jpc.examples.metro;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

import java.util.List;

import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Metro;
import org.junit.Test;

public class TestMetro extends AbstractMetroTest {


	@Test
	public void testAllLines() {
		Metro metro = metro();
		List<Line> lines = metro.lines();
		assertNotNull(lines);
		assertEquals(lines.size(), 6);
		
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
		
		line = metro.line("line1");
		assertNull(line);
	}
	
}
