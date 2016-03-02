all:
	@javac -cp .. *.java

less:
	@javac -cp .. *.java 2>&1 | less

clean:
	@rm *.class

test: all
	@java -cp .. oppg6.TestOppg6
