:- initialization((
	set_logtalk_flag(optimize, on),
	set_logtalk_flag(source_data, on),
	logtalk_load_context(directory, Directory),
	assertz(logtalk_library_path(jpc_examples_scripts, Directory)),
	assertz(logtalk_library_path(metro_lib, jpc_examples_scripts('../src/main/resources/org/jpc/examples/metro/'))),
    logtalk_load(metro_lib(generate_docs)),
	logtalk_load(metro_lib(generate_diagrams)),
	halt
)).
