% loader of all libraries

%  From the Logtalk documentation:
%  Is handy to be able to reload a loader file even if not modified in
%  order to reload any modified application source files.  This can be
%  ensured, independent of global vaue of the `reload` flag, using the
%  following directive (whose scope is local to this file):

:- set_logtalk_flag(reload, always).


:- initialization((
	set_logtalk_flag(report, off),
	set_logtalk_flag(source_data, on),
	logtalk_load(library(types_loader)),
	logtalk_load([metro, station, line])
)).
