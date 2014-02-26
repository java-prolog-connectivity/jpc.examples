package org.jpc.examples.metro.model;

import java.util.List;

public interface Metro {

	public List<Line> lines();
	
	public Line line(String s);
	
}
