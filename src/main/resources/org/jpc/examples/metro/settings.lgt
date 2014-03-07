:- initialization((
	set_logtalk_flag(source_data, on),
	logtalk_load_context(directory, Directory),
	assertz(logtalk_library_path(metro_lib, Directory))
)).
