#!/usr/bin/make -f
# -*- made:makefile -*-

SRC := src/
CLASSES := classes/

JVC := javac
FLEX := jflex
CUP := cup
CP := cp

FLEXFLAG := -d
CUPFLAG := -nowarn -destdir 

.SUFFIXES: .java .class

default: jflex cup copyfiles compile  execute

all: clean jflex cup copyfiles compile execute

jflex:
	$(FLEX) $(FLEXFLAG) $(CLASSES) $(SRC)*.fle

cup:
	$(CUP) $(CUPFLAG) $(CLASSES) $(SRC)*.cup

copyfiles:
	$(CP) $(SRC)*.java $(CLASSES)

compile:
	$(JVC) $(CLASSES)*.java

execute:
	$(MAKE) -C $(CLASSES) execute

clean:
	$(RM) $(CLASSES)*.*
