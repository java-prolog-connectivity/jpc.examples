package org.jpc.examples.metro.model.llapi;

import org.jpc.examples.metro.MetroExample;
import org.jpc.examples.metro.model.AllMetroTests;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AllMetroTests.class})
public class LowLevelApiTestSuite {
	@BeforeClass
    public static void oneTimeSetUp() {
		MetroExample.setFactory(new MetroFactoryLLApi());
		if(!MetroExample.loadAll()) { //load logic files
			throw new RuntimeException();
		}
		MetroExample.removeData();
		MetroExample.importFromPrologFile(); //import data to the logic database from text file
    }
}
