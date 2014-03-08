#!/bin/bash

SCRIPTSDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
DIR=$SCRIPTSDIR/..

#cleaning up
rm -R $DIR/docs/logtalkdocs
mkdir $DIR/docs/logtalkdocs
mkdir $DIR/docs/logtalkdocs/underground_example

#generating intermediate files
sh logtalk

#generating logtalkdocs
sh logtalkdocs.sh

#generating diagrams
sh logtalkdiagrams.sh
