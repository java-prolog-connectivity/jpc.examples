package org.jpc.examples.metro;

import org.jpc.term.TermConvertable;


public interface Line extends TermConvertable {
	
	public boolean connects(Station s1, Station s2);

	public long segments();

}
