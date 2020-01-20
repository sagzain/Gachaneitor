GCCHEF := gcchef/
AC := AutoChef/

BIN := bin/
LIB := lib/
SRC := src/
ANA := analizador/
APP := aplicacion/
DOM := dominio/
PRE := presentacion/
RES := resources/

MKFILE := Makefile
MAIN := Main.java
JFLEXJAR := jflex-full-1.7.0.jar
JFLEXFILE := gcchef.jflex
CUPJAR := java-cup-11b.jar
CUPFILE := gcchef.cup
CUPRUN := java-cup-11b-runtime.jar
FILESJAVA := *.java

MKDIR := mkdir
CP := cp
JV := java
JVC := javac

RMCPFLAG := -r
MKDIRFLAG := -p
JARFLAG := -jar
JVDIRFLAG := -d
CUPFLAG := -destdir
JVCFLAG := -cp
MKFLAG := -C

FLAG := -
TARGET := *

default: cleancompiler project compile execute

cleanaplication:
	$(RM) $(RMCPFLAG) $(AC)$(BIN)*

cleancompiler:
	$(RM) $(RMCPFLAG) $(AC)$(BIN)
	$(RM) $(RMCPFLAG) $(AC)$(LIB)
	$(RM) $(RMCPFLAG) $(AC)$(SRC)

project: directories files compiler

directories:
	$(MKDIR) $(MKDIRFLAG) $(AC)$(BIN)$(APP)$(PRE)
	$(MKDIR) $(AC)$(LIB)
	$(MKDIR) $(MKDIRFLAG) $(AC)$(SRC)$(ANA)

files:
	$(CP) $(GCCHEF)$(SRC)$(ANA)$(MAIN) $(AC)$(SRC)$(ANA)
	$(CP) $(GCCHEF)$(SRC)$(MKFILE) $(AC)$(BIN)
	$(CP) $(GCCHEF)$(LIB)$(CUPRUN) $(AC)$(LIB)
	$(CP) $(RMCPFLAG) $(GCCHEF)$(SRC)$(APP) $(AC)$(SRC)
	$(CP) $(RMCPFLAG) $(AC)$(SRC)$(APP)$(PRE)$(RES) $(AC)$(BIN)$(APP)$(PRE)

compiler: jflex cup

jflex:
	$(JV) $(JARFLAG) $(GCCHEF)$(LIB)$(JFLEXJAR) $(JVDIRFLAG) $(AC)$(SRC)$(ANA) $(GCCHEF)$(SRC)$(ANA)$(JFLEXFILE)

cup:
	$(JV) $(JARFLAG) $(GCCHEF)$(LIB)$(CUPJAR) $(CUPFLAG) $(AC)$(SRC)$(ANA) $(GCCHEF)$(SRC)$(ANA)$(CUPFILE)

compile:
	$(JVC) $(JVCFLAG) $(AC)$(LIB)$(CUPRUN) $(JVDIRFLAG) $(AC)$(BIN) $(AC)$(SRC)$(APP)$(DOM)$(FILESJAVA) $(AC)$(SRC)$(APP)$(PRE)$(FILESJAVA) $(AC)$(SRC)$(ANA)$(FILESJAVA)  

execute:
	$(MAKE) $(MKFLAG) $(AC)$(BIN) FLAG=$(FLAG) TARGET=$(TARGET)

