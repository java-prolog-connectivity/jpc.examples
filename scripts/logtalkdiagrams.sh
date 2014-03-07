#!/bin/bash

#Generates pdf files from dot files

SRCDIR=.
TARGETDIR=../docs/logtalkdocs/underground_example

dot -Tpdf $SRCDIR/metro_lib_entity_diagram.dot > $TARGETDIR/metro_lib_entity_diagram.pdf
dot -Tpdf $SRCDIR/metro_lib_uses_diagram.dot > $TARGETDIR/metro_lib_uses_diagram.pdf
dot -Tpdf $SRCDIR/metro_lib_xref_diagram.dot > $TARGETDIR/metro_lib_xref_diagram.pdf
