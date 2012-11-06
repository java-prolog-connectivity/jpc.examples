package org.jpc.examples.metro;


public interface IMetroFactory {

	public abstract IMetro metro();

	public abstract IStation station(String name);

	public abstract ILine line(String name);
	
}
