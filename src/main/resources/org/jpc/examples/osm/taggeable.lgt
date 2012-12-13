:- category(taggeable(_Tags)).

	:- info([
		author is 'Sergio Castro',
		comment is 'A Taggeable object',
		parameters is [
			'Tags' - 'The tags of this object']
			]).

	:- public([tags/1, tag/2]).

	tags(Tags) :- parameter(1, Tags).

	tag(Key, Value) :- tags(Tags), list::member(Key-Value,Tags).

:- end_category.
