% loader of all libraries + generator of documentation

:- initialization((
	set_logtalk_flag(optimize, on),
	logtalk_load_context(directory, Directory),
	assertz(logtalk_library_path(metro_lib, Directory)),
	logtalk_load(load_all),
	logtalk_load(lgtdoc(loader)),
	lgtdoc::rlibrary(metro_lib)
)).
