.PHONY: flex cup tac-full

DIRRES		:= resources/
SRC := src/
CLASSES := classes/
LIB := libs/

JVC := javac
FLEX := jflex
CUP := cup
JVM := java

JVMFLG := -cp "$(CLASSES):$(LIB)*"
JFLAGS := -cp "$(LIB)*:$(CLASSES)*" -d $(CLASSES)
FLEXJAR := jflex-full-1.7.0.jar
FLEXC := java -jar $(LIB)$(FLEXJAR)
FLEXFLAGS := -d $(CLASSES)
TACJAR := gachaneitor.jar
MAINCLASS := TACScanner

CUPJAR := java-cup-11b.jar
CUPC := java -jar $(LIB)$(CUPJAR)
CUPFLAGS := -destdir $(CLASSES)

FLEXFLAG := -d
CUPFLAG2 := -nowarn -destdir 

.SUFFIXES: .java .class

default: flex compileObjects cup2 compile2

all: clean jflex cup compile execute

flex:
	$(FLEXC) $(FLEXFLAGS) $(SRC)gachaneitor.fle

compileObjects:
	$(JVC) -cp ".:./jars/common.jar" -d $(CLASSES) $(SRC)Ingrediente.java
cup:
	$(CUPC) $(CUPFLAGS) $(SRC)gachaneitor.cup

compile:
	$(JVC) $(JFLAGS) $(CLASSES)*.java

jflex:
	$(FLEX) $(FLEXFLAG) $(CLASSES) $(SRC)*.fle

javaObjects:
	$(JVC) -cp ".:./jars/common.jar" $(SRC)Ingrediente.java
	java -cp ".:./jars/common.jar" $(SRC)Ingrediente.java

cup2:
	$(CUP) $(CUPFLAG2) $(CLASSES) $(SRC)*.cup

compile2:
	$(JVC) $(CLASSES)scanner.java $(CLASSES)sym.java $(CLASSES)parser.java

execute:
	$(MAKE) -C $(CLASSES) execute

clean:
	$(RM) $(CLASSES)*.*
