package org.jpc.examples.metro.model.hlapi;

import static junit.framework.Assert.assertTrue;

import org.jpc.examples.metro.MetroExample;
import org.jpc.examples.metro.model.AllMetroTests;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AllMetroTests.class, ConversionsTest.class})
public class HighLevelApiTestSuite {
	@BeforeClass
    public static void oneTimeSetUp() {
		MetroExample.setFactory(new MetroFactoryHLApi());
		assertTrue(MetroExample.loadAll()); //load logic files
		MetroExample.removeData();
		MetroExample.importFromRawDataFile(); //import data to the logic database from text file
    }
}
