package org.jpc.examples.metro;

import static org.junit.Assert.assertTrue;

import org.jpc.examples.metro.model.AbstractMetroTest;
import org.jpc.examples.metro.model.Line;
import org.jpc.examples.metro.model.Metro;
import org.jpc.examples.metro.model.Station;
import org.jpc.examples.metro.model.hlapi.MetroHLApi;
import org.junit.BeforeClass;
import org.junit.Test;

public class StressTest extends AbstractMetroTest {
//
//	@BeforeClass
//    public static void oneTimeSetUp() {
//		assertTrue(MetroImp.loadAll());
//    }
	
	//public static int TIMES = 50000;
	public static int TIMES = 1;
	public static long milliSeconds(long start, long end) {return (end - start)/1000000;}
	
	@Test
	public void testLineConnects_Station_Station() {
		Line line1 = line("central");
		Station station1 = station("bond_street");
		Station station2 = station("oxford_circus");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			line1.connects(station1, station2);
		}
		long endTime = System.nanoTime();
		//System.out.println("(PAPER)*** testLineConnects_Station_Station: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testLineSegments() {
		Line line1 = line("central");
		long startTime = System.nanoTime();
		
		for(int i=0; i<TIMES;i++) {
			line1.segments();
		}
		long endTime = System.nanoTime();
		//System.out.println("(PAPER)*** testLineSegments: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testStationConnected_Station() {
		Station station1 = station("bond_street");
		Station station2 = station("oxford_circus");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			//System.out.println(station1.connected(station2));
			station1.connected(station2);
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				throw new RuntimeException(e);
//			}
		}
		long endTime = System.nanoTime();
		//System.out.println("*** testStationConnected_Station: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testStationNumberConnections() {
		Station station = station("bond_street");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			station.numberConnections();
		}
		long endTime = System.nanoTime();
		//System.out.println("*** testStationNumberConnections: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testStationConnected_Line() {
		Station station1 = station("bond_street");
		Line line1 = line("central");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			station1.connected(line1);
		}
		long endTime = System.nanoTime();
		//System.out.println("(PAPER)*** testStationConnected_Line: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testStationConnected() {
		Station station1 = station("bond_street");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			station1.connected();
		}
		long endTime = System.nanoTime();
		//System.out.println("*** testStationConnected: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testStationNearby_Station() {
		Station station1 = station("bond_street");
		Station station2 = station("oxford_circus");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			station1.nearby(station2);
		}
		long endTime = System.nanoTime();
		//System.out.println("*** testStationNearby_Station: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testStationNumberNearbyStations() {
		Station station1 = station("bond_street");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			station1.numberNearbyStations();
		}
		long endTime = System.nanoTime();
		//System.out.println("*** testStationNumberNearbyStations: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testStationNearby() {
		Station station1 = station("bond_street");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			station1.nearby();
		}
		long endTime = System.nanoTime();
		//System.out.println("(PAPER)*** testStationNearby: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testStationReachable_Station() {
		Station station1 = station("bond_street");
		Station station2 = station("oxford_circus");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			station1.reachable(station2);
		}
		long endTime = System.nanoTime();
		//System.out.println("*** testStationReachable_Station: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testStationNumberReachableStations() {
		Station station1 = station("bond_street");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			station1.numberReachableStations();
		}
		long endTime = System.nanoTime();
		//System.out.println("*** testStationNumberReachableStations: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testStationIntermediateStations_Station() {
		Station station1 = station("bond_street");
		Station station2 = station("oxford_circus");
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
//			System.out.println(station1.intermediateStations(station2));
			station1.intermediateStations(station2);
		}
		long endTime = System.nanoTime();
		//System.out.println("(PAPER)*** testStationIntermediateStations_Station: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testMetroLines() {
		Metro metro = metro();
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			metro.lines();
		}
		long endTime = System.nanoTime();
		//System.out.println("(PAPER)*** testMetroLines: "+ milliSeconds(startTime, endTime));
	}
	
	@Test
	public void testMetroLine_String() {
		Metro metro = metro();
		
		long startTime = System.nanoTime();
		for(int i=0; i<TIMES;i++) {
			metro.line("central");
		}
		long endTime = System.nanoTime();
		//System.out.println("(PAPER)*** testMetroLine_String: "+ milliSeconds(startTime, endTime));
	}
	

}
