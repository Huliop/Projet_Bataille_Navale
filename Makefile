all: source launch

source:
	javac -d bin src/*.java

launch:
	java -cp bin Jeu

clean:
	rm -R bin/*
