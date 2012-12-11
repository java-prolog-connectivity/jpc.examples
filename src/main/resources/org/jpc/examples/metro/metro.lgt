:- object(metro).

	:- info([
		author is 'Sergio Castro',
		comment is 'The Londom metro. Taken from the "Simply logic" book (Peter Flach).'
	]).
	:- public([connected/3, nearby/2, reachable/3, line/1]).
    :- dynamic(connected/3).

	nearby(X,Y):-connected(X,Y,L).
	nearby(X,Y):-connected(X,Z,L),connected(Z,Y,L).
	
	reachable(X,Y,[]):-connected(X,Y,L).
	reachable(X,Y,[Z|R]):-connected(X,Z,L),reachable(Z,Y,R).

	line(Name) :- setof(L, S1^S2^connected(S1,S2,L), AllLines), list::member(line(Name), AllLines).
    	
:- end_object.
