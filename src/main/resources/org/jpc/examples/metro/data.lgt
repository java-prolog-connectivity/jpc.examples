:- line(central)::add_connection(station(bond_street),station(oxford_circus)).
:- line(central)::add_connection(station(oxford_circus),station(tottenham_court_road)).

:- line(jubilee)::add_connection(station(bond_street),station(green_park)).
:- line(jubilee)::add_connection(station(green_park),station(charing_cross)).

:- line(piccadilly)::add_connection(station(green_park),station(piccadilly_circus)).
:- line(piccadilly)::add_connection(station(piccadilly_circus),station(leicester_square)).

:- line(victoria)::add_connection(station(green_park),station(oxford_circus)).

:- line(bakerloo)::add_connection(station(oxford_circus),station(piccadilly_circus)).
:- line(bakerloo)::add_connection(station(piccadilly_circus),station(charing_cross)).

:- line(northern)::add_connection(station(tottenham_court_road),station(leicester_square)).
:- line(northern)::add_connection(station(leicester_square),station(charing_cross)).
