package org.jpc.examples.metro;

import java.util.List;

import org.jpc.term.TermConvertable;

public interface Metro extends TermConvertable {

	public abstract List<Line> lines();
	
	public abstract Line line(String s);
	
}
