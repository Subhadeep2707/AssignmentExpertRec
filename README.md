# Technical Problem

We have a program that takes a url as a command line paramter. It fetches the url and print the headers and the content.  The headers are printed to the console as a key value dictionary, while the content is written to a file taken as an additional parameter.  The http status code is the exit code for our application, except for 200, which should be mapped to 0(success) exit code.
Also, if the content is html, the title is printed on the console.

# Installation Steps

To compile and run the project follow these simple steps.

# Prerequisites

- Java 1.8+
- Maven 3.6.0+

# Installation

1. Clone the repository
```
git clone git@github.com:Subhadeep2707/AssignmentExpertRec.git
cd AssignmentExpertRec
```
2. Build the project using maven
```
mvn clean install
```
3. Run the project
```
java -jar target\AssignmentExpertRec-1.0-SNAPSHOT-jar-with-dependencies.jar -u https://www.google.com -f google.txt
```

# Example
```
java -jar target\AssignmentExpertRec-1.0-SNAPSHOT-jar-with-dependencies.jar -u https://www.google.com -f google.txt
```
Output:

```
Status code = 200


File created: google.txt
Successfully wrote to the file.

Headers:

X-Frame-Options : SAMEORIGIN
Transfer-Encoding : chunked
Cache-Control : private, max-age=0
Server : gws
Alt-Svc : h3-29=":443"; ma=2592000,h3-T051=":443"; ma=2592000,h3-Q050=":443"; ma=2592000,h3-Q046=":443"; ma=2592000,h3-Q043=":443"; ma=2592000,quic=":443"; ma=2592000; v="46,43"
Set-Cookie : NID=210=oXXZ1XJHxPVXdOv3PFQSeLiil7xGusPY_xFYKIqH5XFUq3U-F7Ckrl5n38aMTT6GZyIjPNh1I3ET7d1c-e3yHx5SSLLZOcDvScw9xVtbnNHNhZg4Zi8oIvi5A3ku39BEQEEm1DP81TzkLR1yripVwV-y82lbEKa16gZcGHnB59k; expires=Mon, 06-Sep-2021 21:44:38 GMT; path=/; domain=.google.com; HttpOnly
Expires : -1
P3P : CP="This is not a P3P policy! See g.co/p3phelp for more info."
X-XSS-Protection : 0
Date : Sun, 07 Mar 2021 21:44:38 GMT
Content-Type : text/html; charset=ISO-8859-1


Title = Google
```

Also, a file google.txt gets created inside AssignmentExpertRec directory, containing the response body for the url.
