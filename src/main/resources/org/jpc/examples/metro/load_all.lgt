% loader of all libraries

:- initialization((
	set_logtalk_flag(report, off),
	logtalk_load(library(types_loader)),
	logtalk_load(metro),
	logtalk_load(station),
	logtalk_load(line)
)).
