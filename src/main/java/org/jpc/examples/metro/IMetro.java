package org.jpc.examples.metro;

import java.util.List;

public interface IMetro {

	public abstract List<ILine> lines();
	
	public abstract ILine line(String s);
	
}
