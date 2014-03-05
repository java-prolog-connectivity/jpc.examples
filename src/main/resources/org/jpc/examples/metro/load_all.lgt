% loader of all libraries

:- initialization((
	set_logtalk_flag(report, off),
	set_logtalk_flag(dynamic_declarations, allow),
	logtalk_load(library(types_loader)),
	logtalk_load([metro, station, line], [source_data(on)])
)).
