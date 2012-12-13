package org.jpc.examples.osm;

import static junit.framework.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class OsmTestSuite {
	@BeforeClass
    public static void oneTimeSetUp() {
		assertTrue(OsmExample.loadAll()); //load logic files
		OsmExample.importData(); //import data to the logic database from text file
    }
}
