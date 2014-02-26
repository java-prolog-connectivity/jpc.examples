package org.jpc.examples.metro.model;


public interface MetroFactory {
	
	public Metro metro();

	public Station station(String name);

	public Line line(String name);
	
}
