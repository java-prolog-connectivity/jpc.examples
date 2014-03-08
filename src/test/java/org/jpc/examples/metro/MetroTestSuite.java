package org.jpc.examples.metro;

import org.jpc.examples.metro.model.hlapi.HighLevelApiTestSuite;
import org.jpc.examples.metro.model.llapi.LowLevelApiTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({LowLevelApiTestSuite.class, HighLevelApiTestSuite.class})
public class MetroTestSuite {}
