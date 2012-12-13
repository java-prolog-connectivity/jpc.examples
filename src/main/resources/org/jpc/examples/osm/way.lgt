:- object(way(_Id,_Nodes,_Tags)).

	:- info([
		author is 'Sergio Castro',
		comment is 'A OSM way',
		parameters is [
			'Id' - 'The id of the way',
			'Nodes' - 'The nodes composing the way',
			'Tags' - 'The tags of the way']
			]).

	:- public([id/1, nodes/1, tags/1, tag/2]).
	
	id(Id) :- parameter(1, Id).
		
	nodes(Nodes) :- parameter(2, Nodes).
		
	tags(Tags) :- parameter(3, Tags).

:- end_object.
