package org.jpc.examples.helloworld;

import static java.util.Arrays.asList;
import static org.jpc.engine.provider.PrologEngineProviderManager.getPrologEngine;

import org.jpc.term.Atom;
import org.jpc.term.Compound;

public class HelloWorld {

	public static void main(String[] args) {
		 getPrologEngine().query("write('hello world')");
		 //structured version:
		 getPrologEngine().query(new Compound("write", asList(new Atom("hello world"))));
	}
	
}
