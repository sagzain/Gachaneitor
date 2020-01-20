EXTENSION := .atcf

ANA := analizador/
MEN := ../menus/
LIB := ../lib/

MAIN := Main
CUPRUN := java-cup-11b-runtime.jar
EXTJAR := :.

JV := java

JVFLAG := -cp

default:
	$(JV) $(JVFLAG) $(LIB)$(CUPRUN)$(EXTJAR) $(ANA)$(MAIN) $(FLAG) $(MEN)$(TARGET)$(EXTENSION)
