#!/bin/bash

SCRIPTSDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
DIR=$SCRIPTSDIR/..

cd $SCRIPTSDIR/xml_docs
lgt2html -d $DIR"/docs/logtalkdocs/underground_example" -t "Logtalk Entities for the London Underground Example"
