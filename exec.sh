#!/bin/bash

# Add your shell script code here
rm *.class

# compile .java files using javac command
javac --module-path ".\javafx-sdk-21.0.2/lib;.\lib/exp4j-0.4.8-sources.jar" --add-modules javafx.controls,javafx.fxml,exp4j Controller.java

javac --module-path ".\javafx-sdk-21.0.2/lib;.\lib/exp4j-0.4.8-sources.jar" --add-modules javafx.controls,javafx.fxml,exp4j Main.java

# run the .class file using java command
java --module-path ".\javafx-sdk-21.0.2/lib;.\lib/exp4j-0.4.8-sources.jar" --add-modules javafx.controls,javafx.fxml,exp4j Main

# End of script
