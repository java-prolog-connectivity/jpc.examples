#!/bin/bash

sh default_logtalk

#cleaning up
rm -R ../docs/logtalkdocs
mkdir ../docs/logtalkdocs
mkdir ../docs/logtalkdocs/underground_example

#generating diagrams
sh logtalkdiagrams.sh

#generating logtalkdocs
sh logtalkdocs.sh
