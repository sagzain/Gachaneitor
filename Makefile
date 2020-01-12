#!/usr/bin/make -f
# -*- made:makefile -*-

SRC := src/
CLASSES := classes/

JVC := javac
FLEX := jflex
CUP := cup

FLEXFLAG := -d
CUPFLAG := -nowarn -destdir 

.SUFFIXES: .java .class

default: jflex cup compile execute

all: flex cup compile execute

jflex:
	$(FLEX) $(FLEXFLAG) $(CLASSES) $(SRC)*.fle

cup:
	$(CUP) $(CUPFLAG) $(CLASSES) $(SRC)*.cup

compile:
	$(JVC) $(CLASSES)scanner.java $(CLASSES)sym.java $(CLASSES)parser.java

execute:
	$(MAKE) -C $(CLASSES) execute

clean:
	$(RM) $(CLASSES)*.*
