SRC := src/
CLASSES := classes/

JFLEX := jflex
CUP := cup
CP := cp
JVC := javac

JFLEXFLAG := -d
CUPFLAG := -destdir

TARGET := *

default: clean compile execute

clean:
	$(RM) $(CLASSES)*.*

compile: jflex cup copyfiles compilejava

jflex:
	$(JFLEX) $(JFLEXFLAG) $(CLASSES) $(SRC)*.jfle

cup:
	$(CUP) $(CUPFLAG) $(CLASSES) $(SRC)*.cup

copyfiles:
	$(CP) $(SRC)*.java $(CLASSES)

compilejava:
	$(JVC) $(CLASSES)*.java

execute:
	$(MAKE) -C $(CLASSES) TARGET=$(TARGET)

