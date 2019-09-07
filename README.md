REA Group Toy Robot Simulator Challenge
Example usage
Invoke the toy robot simulator as follows:
java -jar rea-robot-<version>.jar [commands.txt]
The simulator can be invoked with a plain text file containing commands, one command per line. If no command file is given, commands are read form sdtin.
For a specification of the commands and on how the robot reacts to them, see PROBLEM.md.
Getting Started
Build
To build the project, just run mvn clean package. The built JAR along with sample inputs can be found in the ./target/ directory.