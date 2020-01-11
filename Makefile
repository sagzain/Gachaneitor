#!/usr/bin/make -f
# -*- made:makefile -*-

SRC := src/
CLASSES := classes/

JVC := javac
FLEX := jflex
CUP := cup

FLEXFLAG := -d

.SUFFIXES: .java .class

default: jflex compile execute

all: flex cup compile execute

jflex:
	$(FLEX) $(FLEXFLAG) $(CLASSES) $(SRC)*.jflex

cup:
	#Próximamente

compile:
	$(JVC) $(CLASSES)*.java

execute:
	$(MAKE) -C $(CLASSES) execute

clean:
	$(RM) ./classes/*
