package org.jpc.examples.helloworld;

import static java.util.Arrays.asList;
import static org.jpc.engine.provider.PrologEngineProviderManager.getPrologEngine;

import org.jpc.term.Atom;
import org.jpc.term.Compound;

public class HelloWorld {

	/**
	 * Plain text version.
	 */
	public static void textHelloWorld() {
		getPrologEngine().query("write('hello world')").oneSolution();
	}
	
	/**
	 * Structured version.
	 */
	public static void structuredHelloWorld() {
		getPrologEngine().query(new Compound("write", asList(new Atom("hello world")))).oneSolution();
	}
	
	public static void main(String[] args) {
		textHelloWorld();
		getPrologEngine().flushOutput();
		structuredHelloWorld();
		getPrologEngine().flushOutput();
	}
	
}
