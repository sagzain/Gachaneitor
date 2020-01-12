#!/usr/bin/make -f
# -*- made:makefile -*-

SRC := src/
CLASSES := classes/

JVC := javac
FLEX := jflex
CUP := cup

FLEXFLAG := -d
CUPFLAG := -destdir

.SUFFIXES: .java .class

default: cup jflex compile execute

all: flex cup compile execute

jflex:
	$(FLEX) $(FLEXFLAG) $(CLASSES) $(SRC)*.jflex

cup:
	$(CUP) $(CUPFLAG) $(CLASSES) $(SRC)*.cup

compile:
	$(JVC) $(CLASSES)*.java

execute:
	$(MAKE) -C $(CLASSES) execute

clean:
	$(RM) ./classes/*
