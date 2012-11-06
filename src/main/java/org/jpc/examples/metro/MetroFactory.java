package org.jpc.examples.metro;


public class MetroFactory implements IMetroFactory {

	@Override
	public IStation station(String name) {
		return new Station(name);
	}
	
	@Override
	public ILine line(String name) {
		return new Line(name);
	}

	@Override
	public IMetro metro() {
		return new Metro();
	}
	
}
