package org.jpc.examples.metro;

import static junit.framework.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MetroTest.class, StationTest.class, LineTest.class})
public class MetroTestSuite {
	@BeforeClass
    public static void oneTimeSetUp() {
		assertTrue(MetroExample.loadAll()); //load logic files
		MetroExample.importData(); //import data to the logic database from text file
    }
}
