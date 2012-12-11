% loader of all libraries

:- initialization((
	set_logtalk_flag(report, off),
	set_logtalk_flag(dynamic_declarations, allow),
	logtalk_load(library(types_loader)),
	logtalk_load(metro),
	logtalk_load(station),
	logtalk_load(line)
)).
