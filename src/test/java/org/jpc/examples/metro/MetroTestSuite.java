package org.jpc.examples.metro;

import static junit.framework.Assert.assertTrue;

import org.jpc.examples.metro.imp.MetroImp;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestMetro.class, TestStation.class, TestLine.class})
public class MetroTestSuite {
	@BeforeClass
    public static void oneTimeSetUp() {
		assertTrue(MetroImp.loadAll());
    }
}
