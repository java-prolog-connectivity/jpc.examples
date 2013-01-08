package org.jpc.examples.osm;

import static junit.framework.Assert.assertTrue;

import org.jpc.examples.osm.imp.OsmExample;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({OsmTest.class})
public class OsmTestSuite {
	@BeforeClass
    public static void oneTimeSetUp() {
		assertTrue(OsmExample.loadAll()); //load logic files
		OsmExample.importData(); //import data to the logic database from text file
    }
}
