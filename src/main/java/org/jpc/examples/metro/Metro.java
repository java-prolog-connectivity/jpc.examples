package org.jpc.examples.metro;

import java.util.List;

public interface Metro {

	public abstract List<Line> lines();
	
	public abstract Line line(String s);
	
}
