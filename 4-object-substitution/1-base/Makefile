SRC = src
BUILD = build
DOC = doc
TEST = tst

JC = javac
JCFLAGS = -g -encoding utf8 -d $(BUILD) -classpath $(BUILD) -sourcepath $(SRC):$(TEST)

JDOC = javadoc
JDOCFLAGS = -author

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JCFLAGS) $*.java

JAVASRC = $(shell ls $(SRC)/tec/*.java tst/tec/*.java recette/Simple.java)
CLASSES = $(JAVASRC:.java=.class)

all: classes

default: classes

classes: $(CLASSES:.java=.class)

run:
	java -classpath $(BUILD) Simple

test:
	java -ea -classpath $(BUILD) tec.LancerTests

doc:
	mkdir -p doc
	$(JDOC) $(JDOCFLAGS) -d doc *.java

clean:
	rm -rf $(BUILD)/*
	rm -fr $(DOC)
