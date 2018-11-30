# JavaWebDevSpark

An introduction to the Spark framework from the Treehouse course on Java web development.

## Last Updated: 30/11/2018

## Aim
To design a web applicaiton (using Spark) that allows people to suggest and vote for courses they would like to see on treehouse.

## Instructions and Navigation
1) To access the site run the App Class and visit http://localhost:4567 in the browser.
2) Fill out the form with your name and click sign in
3) Click the link to course ideas
4) Vote for an existing idea OR suggest your own
5) Click on the course idea to see who voted for it
6) Repeat as a new user (currently have to clear your cookies in order to sign in as a new user)

## Pages
* Index page
* Sign-In page
* Course Ideas page
* Individual Idea pages
* Not-Found page

## Tools Utilised

### Routes
The main feature of spark is using _routes_ to make HTTP requests providing functionality. Routes are constructed of three parts.

1) The Verb: get, post, put, delete, head, trace, connect, options
2) The Path: /hello, /users/:name
3) The Callback: (request, response) -> { }

For example


``` import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
```
* The get, post, put and delete verbs are the familiar HTTP requests. In the Appp class you will see them used in conjunction with the filter _before_ and the exception _exception_ .

* The callback uses a _java lambda_ which is a feature of Java 8 https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach5. There are many requests and repsonses you can make which are given in the Spark documentation http://sparkjava.com/documentation#request.

### Handlebars
* In this project I used the handlebars as a template engine following the example from:
https://github.com/perwendel/spark-template-engines/tree/master/spark-template-handlebars

* Handlebars sits on top of Spark and aids in keeping code DRY by allowing new pages to inherit from a base template (in this project the base template is base.hbs). Handlebars provides override methods that utilises _partials_ to make each page unique. https://github.com/jknack/handlebars.java

### Slugify

* The slugify dependency used to generate a meaningful name for URL's that would otherwise be accessed through an ID (https://github.com/slugify/slugify)

## Dependencies 
See the pom.xml file

## Bugs to Fix
* The flash messages are not displaying in the browser
* Refreshing the page should end the current session and begin a new one, prompting the user to sign-in again. It does not.

## Viable improvements to be made
* Migrate the HTTP requests from main into their own class
* Add Unit tests
* Avoid the use of static methods where possible
