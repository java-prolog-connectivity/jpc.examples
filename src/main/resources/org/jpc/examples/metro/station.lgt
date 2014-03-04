:- object(station(_Name)).

	:- info([
		author is 'Sergio Castro',
		comment is 'A metro station',
		parameters is [
			'Name' - 'The name of the station']
	]).
	
	:- public([name/1, connected/1, connected/2, nearby/1, reachable/1, reachable/2]).

	:- info(name/1, [
    	comment is 'Name is the station name.',
    	argnames is ['Name']
	]).
	name(Name) :- parameter(1, Name).
	
	:- info(connected/1, [
    	comment is 'Station is a connected station.',
    	argnames is ['Station']
	]).
	connected(Station) :- connected(Station, _).
	
	:- info(connected/2, [
    	comment is 'Station is a connected station by means of Line.',
    	argnames is ['Station', 'Line']
	]).
	connected(Station, L) :- self(Self), metro::connected(Self, Station, L).
	
	:- info(nearby/1, [
    	comment is 'Station is a nearby station.',
    	argnames is ['Station']
	]).
	nearby(Station) :- self(Self), metro::nearby(Self, Station).
	
	:- info(reachable/1, [
    	comment is 'Station is a reachable station.',
    	argnames is ['Station']
	]).
	reachable(Station) :- reachable(Station, _).
	
	:- info(reachable/2, [
    	comment is 'Station is a reachable station by means of traversing IntermediateStations.',
    	argnames is ['Station', 'IntermediateStations']
	]).
	reachable(Station, IntermediateStations) :- self(Self), metro::reachable(Self, Station, IntermediateStations).
	
:- end_object.
