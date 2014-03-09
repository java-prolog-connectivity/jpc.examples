#!/bin/bash

SCRIPTSDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
DIR=$SCRIPTSDIR/..

#cleaning up
rm -R $DIR/docs/logtalkdocs
mkdir $DIR/docs/logtalkdocs
mkdir $DIR/docs/logtalkdocs/underground_example

#generating intermediate files
#the following assumes that the symbolic link "logtalk" has been set (e.g., by means of the "logtalk_backend_select" script) pointing to the preferred logtalk executable.
sh logtalk

#generating logtalkdocs
sh logtalkdocs.sh

#generating diagrams
sh logtalkdiagrams.sh
