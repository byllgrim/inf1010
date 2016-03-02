all:
	@javac -cp .. -Xlint:unchecked *.java

less:
	@javac -cp .. -Xlint:unchecked *.java 2>&1 | less

clean:
	@rm *.class

test: all
	@java -cp .. oppg6.TestOppg6
