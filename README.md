# Technical Problem

We have a program that takes a url as a command line paramter. It fetches the url and print the headers and the content.  The headers are printed to the console as a key value dictionary, while the content is written to a file taken as an additional parameter.  The http status code is the exit code for our application, except for 200, which should be mapped to 0(success) exit code.
Also, if the content is html, the title is printed on the console.

# Installation Steps

To compile and run the project follow these simple steps.

# Prerequisites

Java 1.8+
Maven 3.6.0+

# Installation

1. Clone the repository
git clone git@github.com:Subhadeep2707/AssignmentExpertRec.git
cd AssignmentExpertRec
2. Build the project using maven
mvn clean install
3. Run the project
java -jar target\TakeHomeTest-1.0-jar-with-dependencies.jar customers.txt
