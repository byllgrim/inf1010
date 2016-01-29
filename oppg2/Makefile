all:
	javac *.java

doc: all
	javadoc -d Documentation -private *.java

clean:
	rm *.class

test: all
	java BokTest
	java HylleTest
