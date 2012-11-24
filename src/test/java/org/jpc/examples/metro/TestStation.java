package org.jpc.examples.metro;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.jpc.examples.metro.Line;
import org.jpc.examples.metro.Station;
import org.junit.Test;
import org.minitoolbox.BeansUtil;

public class TestStation extends MetroExampleTest {


	@Test
	public void testAllConnections() {
		Station station1 = station("bond_street");
		List<Station> connectedStations = station1.connected();
		assertEquals(connectedStations.size(), 2);
		
//		System.out.println("Stations connected to " + station1 + ": " + connectedStations.size());
//		for(IStation connectedStation: connectedStations) {
//			System.out.println("- " + connectedStation);
//		}
		
		Station station2 = station("inexisting_station");
		assertEquals(station2.connected().size(), 0);
	}
	
	@Test
	public void testOneConnection() {
		Station station = station("bond_street");
		Line line1 = line("central");
		Line line2 = line("northern");
		Station connectedStation = station.connected(line1);
		assertNotNull(connectedStation);
		assertEquals(BeansUtil.getProperty(connectedStation, "name"), "oxford_circus");
		//System.out.println("The station " + station + " is connected with " + connectedStation + " by means of the line " + line1);
		connectedStation = station.connected(line2);  //no connected with any station by means of line2
		assertNull(connectedStation);
	}
	
	@Test
	public void testNumberConnections() {
		Station station = station("bond_street");
		assertEquals(station.numberConnections(), 2);
		//System.out.println("Number of connections of " + station + ": " + station.numberConnections());
	}
	
	@Test
	public void testIsConnected() {
		Station station1 = station("bond_street");
		Station station2 = station("oxford_circus");
		Station station3 = station("charing_cross");
		assertTrue(station1.connected(station2));
		assertFalse(station1.connected(station3));
	}
	
	
	
	@Test
	public void testAllNearbyStations() {
		Station station = station("bond_street");
		List<Station> nearbyStations = station.nearby();
		assertEquals(nearbyStations.size(), 4);
//		System.out.println("Stations nearby to " + station + ": " + nearbyStations.size());
//		for(IStation nearbyStation: nearbyStations) {
//			System.out.println("- " + nearbyStation);
//		}
		
	}
	
	@Test
	public void testNumberNearbyStations() {
		Station station = station("bond_street");
		assertEquals(station.numberNearbyStations(), 4);
		//System.out.println("Number of nearby stations of " + station + ": " + station.numberNearbyStations());
	}
	
	@Test
	public void testIsNearby() {
		Station station1 = station("bond_street");
		Station station2 = station("oxford_circus");
		Station station3 = station("charing_cross");
		Station station4 = station("piccadilly_circus");
		assertTrue(station1.nearby(station2));
		assertTrue(station1.nearby(station3));
		assertFalse(station1.nearby(station4));
	}
	
	
	
	@Test
	public void testIntermediateStations() {
		Station station1 = station("bond_street");
		Station station2 = station("oxford_circus");
		Station station3 = station("piccadilly_circus");
		Station station4 = station("inexisting_station");
		
		List<Station> intermediateStations = station1.intermediateStations(station2);
		assertEquals(intermediateStations.size(), 0);
		
		intermediateStations = station1.intermediateStations(station3);
		assertEquals(intermediateStations.size(), 1);
		
//		System.out.println("Intermediate stations from " + station1 + " to " + station3);
//		for(IStation intermediateStation: intermediateStations) {
//			System.out.println("- " + intermediateStation);
//		}
		
		assertNull(station1.intermediateStations(station4));
	}
	
	@Test
	public void testNumberReachableStations() {
		Station station = station("bond_street");
		assertEquals(station.numberReachableStations(), 22);
		//System.out.println("Number of reachable stations from " + station + ": " + station.numberReachableStations());
	}
	
	@Test
	public void testIsReachable() {
		Station station1 = station("bond_street");
		Station station2 = station("oxford_circus");
		Station station3 = station("charing_cross");
		Station station4 = station("piccadilly_circus");
		Station station5 = station("inexisting_station");
		assertTrue(station1.reachable(station2));
		assertTrue(station1.reachable(station3));
		assertTrue(station1.reachable(station4));
		assertFalse(station1.reachable(station5));
	}
	
}
