:- object(osm).

	:- info([
		author is 'Sergio Castro',
		comment is 'A OSM logic theory'
			]).

	:- public([way/3, node/3, way/2, node/2, run_tests/0]).
	:- dynamic([way/3, node/3]).

	way(Id, way(Id, Nodes, Tags)) :- way(Id, Nodes, Tags).
	
	node(Id, node(Id, Coordinates, Tags)) :- node(Id, Coordinates, Tags).
	
:- end_object.
