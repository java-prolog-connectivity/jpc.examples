package org.jpc.examples;

import org.jpc.examples.metro.MetroTestSuite;
import org.jpc.examples.osm.OsmTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * A suite with all the examples depending on Logtalk
 * @author sergioc
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	MetroTestSuite.class, 
	OsmTestSuite.class})
public class LogtalkExamplesTestSuite {}
