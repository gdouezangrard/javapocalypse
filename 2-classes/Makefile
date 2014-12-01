SRC = src
BUILD = build
DOC = doc

JC = javac
JCFLAGS = -g -encoding utf8 -d $(BUILD) -classpath $(BUILD) -sourcepath $(SRC)

JDOC = javadoc
JDOCFLAGS = -author

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JCFLAGS) $*.java

JAVASRC = $(shell ls $(SRC)/*.java)
CLASSES = $(JAVASRC:.java=.class)

all: classes

default: classes

classes: $(CLASSES:.java=.class)

doc:
	mkdir -p doc
	$(JDOC) $(JDOCFLAGS) -d doc *.java

clean:
	rm -rf $(BUILD)/*
	rm -fr $(DOC)
