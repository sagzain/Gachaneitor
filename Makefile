#!/usr/bin/make -f
# -*- made:makefile -*-

clean:
	$(RM) ./classes/*.class
	$(RM) ./classes/*.java
	$(RM) ./classes/*.java~

run:
	jflex -d ./classes/ ./src/*.jflex
	javac ./classes/*.java

	#modo ejecucion
	#cd ./classes
	#java ./analex ../input/ejemplo.txt
