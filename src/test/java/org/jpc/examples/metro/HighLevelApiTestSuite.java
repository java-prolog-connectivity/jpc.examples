package org.jpc.examples.metro;

import static junit.framework.Assert.assertTrue;

import org.jpc.examples.metro.model.hlapi.MetroFactoryHLApi;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AllMetroTests.class})
public class HighLevelApiTestSuite {
	@BeforeClass
    public static void oneTimeSetUp() {
		MetroExample.setFactory(new MetroFactoryHLApi());
		assertTrue(MetroExample.loadAll()); //load logic files
		//MetroExample.removeData(); //retract_all currently not working in the SVN XSB version
		MetroExample.importFromRawDataFile(); //import data to the logic database from text file
    }
}
