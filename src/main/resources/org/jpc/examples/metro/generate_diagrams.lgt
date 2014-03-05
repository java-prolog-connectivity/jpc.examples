% loader of all libraries + generator of diagrams

:- initialization((
	set_logtalk_flag(optimize, on),
	logtalk_load_context(directory, Directory),
	assertz(logtalk_library_path(metro_lib, Directory)),
	logtalk_load(load_all),
	logtalk_load(diagrams(loader)),
	entity_diagram::rlibrary(metro_lib, [title('Entities Diagram for the London Underground Example')]),
	uses_diagram::rlibrary(metro_lib, [title('Uses Diagram for the London Underground Example')]),
	xref_diagram::rlibrary(metro_lib, [title('Reference Diagram for the London Underground Example')])
)).
