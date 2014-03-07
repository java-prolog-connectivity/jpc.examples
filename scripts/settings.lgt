:- initialization((
	set_logtalk_flag(optimize, on),
	set_logtalk_flag(source_data, on),
	assertz(logtalk_library_path(metro_lib, '../src/main/resources/org/jpc/examples/metro/')),
	logtalk_load(metro_lib(load_all)),
	
	logtalk_load(lgtdoc(loader)),
	lgtdoc::library(metro_lib),
	
	logtalk_load(diagrams(loader)),
	entity_diagram::library(metro_lib, [title('Entities Diagram for the London Underground Example')]),
	uses_diagram::library(metro_lib, [title('Uses Diagram for the London Underground Example')]),
	xref_diagram::library(metro_lib, [title('Reference Diagram for the London Underground Example')])
)).
