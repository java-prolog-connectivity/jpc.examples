:- initialization((
	logtalk_load(metro_lib(load_all)),
	logtalk_load(diagrams(loader)),
	DiagramOutput = dot_diagrams,
	entity_diagram::library(metro_lib, [title('Entities Diagram for the London Underground Example'),output_directory(DiagramOutput)]),
	uses_diagram::library(metro_lib, [title('Uses Diagram for the London Underground Example'),output_directory(DiagramOutput)]),
	xref_diagram::library(metro_lib, [title('Reference Diagram for the London Underground Example'),output_directory(DiagramOutput)])
)).
