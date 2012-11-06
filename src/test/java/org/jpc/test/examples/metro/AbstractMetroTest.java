package org.jpc.test.examples.metro;

import org.jpc.examples.metro.ILine;
import org.jpc.examples.metro.IMetro;
import org.jpc.examples.metro.IMetroFactory;
import org.jpc.examples.metro.IStation;
import org.jpc.examples.metro.MetroFactory;

public class AbstractMetroTest implements IMetroFactory {

	public static IMetroFactory defaultMetroFactory = new MetroFactory();

	
	public IMetroFactory getMetroFactory() {
		return defaultMetroFactory;
	}

	
	@Override
	public IMetro metro() {
		return getMetroFactory().metro();
	}

	public ILine line(String name) {
		return getMetroFactory().line(name);
	}

	public IStation station(String name) {
		return getMetroFactory().station(name);
	}

	/*
	@Parameters
	public static Collection<IMetroObjectProvider[]> objectProviders() {
		return Arrays.asList(new IMetroObjectProvider[][] {
			new IMetroObjectProvider[]{
				new MetroLogicObjectProvider()
			},
			new IMetroObjectProvider[]{
					new MetroJplObjectProvider()
				}
		});
	}
	*/
}
