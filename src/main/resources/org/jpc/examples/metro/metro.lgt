:- object(metro).

	:- info([
		author is 'Sergio Castro',
		comment is 'The London metro. Taken from the "Simply logic" book (Peter Flach).'
	]).
	:- public([connected/3, nearby/2, reachable/3, line/1, remove_all/0]).
	
	:- info(connected/3, [
    	comment is 'Station1 is connected to Station2 by means of Line.',
    	argnames is ['Station1', 'Station2', 'Line']
	]).
    :- dynamic(connected/3).

	:- info(nearby/2, [
    	comment is 'Station1 is nearby Station2.',
    	argnames is ['Station1', 'Station2']
	]).
	nearby(Station1,Station2):-connected(Station1,Station2,_).
	nearby(Station1,Station2):-connected(Station1,IntermediateStation,Line),connected(IntermediateStation,Station2,Line).
	
	:- info(reachable/3, [
    	comment is 'Station2 is reachable from Station1 by means of traversing IntermediateStations.',
    	argnames is ['Station1', 'Station2', 'IntermediateStations']
	]).
	reachable(Station1,Station2,[]):-connected(Station1,Station2,_).
	reachable(Station1,Station2,[Z|R]):-connected(Station1,Z,_),reachable(Z,Station2,R).

	:- info(line/1, [
    	comment is 'Name is the name of a Line.',
    	argnames is ['Name']
	]).
	line(Name) :- setof(Line, Station1^Station2^connected(Station1,Station2,Line), AllLines), list::member(line(Name), AllLines).
   
   	:- info(remove_all/0, [
    	comment is 'Removes all the lines.'
	]).
    remove_all :- metro::retractall(connected(_,_,_)).
    
:- end_object.
