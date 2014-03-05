#!/bin/bash

rm -R docs/logtalkdocs
mkdir docs/logtalkdocs
mkdir docs/logtalkdocs/underground_example

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

cd src/main/resources/org/jpc/examples/metro/xml_docs
lgt2html -d $DIR"/docs/logtalkdocs/underground_example" -t "Logtalk Entities for the London Underground Example"

echo Ok.