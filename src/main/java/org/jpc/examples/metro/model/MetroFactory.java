package org.jpc.examples.metro.model;



public interface MetroFactory {
	
	public abstract Metro metro();

	public abstract Station station(String name);

	public abstract Line line(String name);
	
}
