:- object(line(_Name)).

	:- info([
		author is 'Sergio Castro',
		comment is 'A metro line',
		parameters is [
			'Name' - 'The name of the metro line']
	]).
	
	:- public([name/1, connects/2, add_connection/2]).

	:- info(name/1, [
    	comment is 'Name is the line name.',
    	argnames is ['Name']
	]).
	name(Name) :- parameter(1, Name).
	
	:- info(connects/2, [
    	comment is 'Station1 is connected to Station2 by means of this line.',
    	argnames is ['Station1', 'Station2']
	]).
	connects(Station1, Station2) :- self(Self), metro::connected(Station1, Station2, Self).
	
	:- info(add_connection/2, [
    	comment is 'Station1 is now connected to Station2 by means of this line.',
    	argnames is ['Station1', 'Station2']
	]).
	add_connection(Station1, Station2) :- self(Self), metro::assertz(connected(Station1, Station2, Self)).

:- end_object.
