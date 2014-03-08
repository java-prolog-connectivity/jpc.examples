#!/bin/bash

#Generates html files from the xml doc files

SCRIPTSDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
DIR=$SCRIPTSDIR/../

cd $DIR/src/main/resources/org/jpc/examples/metro/xml_docs
lgt2html -d $DIR"/docs/logtalkdocs/underground_example" -t "Logtalk Entities for the London Underground Example"
