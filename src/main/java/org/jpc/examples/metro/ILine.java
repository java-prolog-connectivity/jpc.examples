package org.jpc.examples.metro;


public interface ILine {
	
	public boolean connects(IStation s1, IStation s2);

	public long segments();

}
