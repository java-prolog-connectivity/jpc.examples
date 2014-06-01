#!/bin/bash

#Generates pdf files from the diagram dot files

SCRIPTSDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
DIR=$SCRIPTSDIR/../

SRCDIR=$DIR/src/main/resources/org/jpc/examples/metro/dot_diagrams/
TARGETDIR=$DIR/docs/logtalkdocs/underground_example/

dot -Tsvg $SRCDIR/metro_lib_entity_diagram.dot > $TARGETDIR/metro_lib_entity_diagram.svg
dot -Tsvg $SRCDIR/metro_lib_uses_diagram.dot > $TARGETDIR/metro_lib_uses_diagram.svg
dot -Tsvg $SRCDIR/metro_lib_xref_diagram.dot > $TARGETDIR/metro_lib_xref_diagram.svg

dot -Tpdf $SRCDIR/metro_lib_entity_diagram.dot > $TARGETDIR/metro_lib_entity_diagram.pdf
dot -Tpdf $SRCDIR/metro_lib_uses_diagram.dot > $TARGETDIR/metro_lib_uses_diagram.pdf
dot -Tpdf $SRCDIR/metro_lib_xref_diagram.dot > $TARGETDIR/metro_lib_xref_diagram.pdf
