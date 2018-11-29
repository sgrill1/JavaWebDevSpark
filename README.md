# JavaWebDevSpark
An introduction to the Spark framework from the Treehouse course on Java web development.

## Feature Branches

### HandleBars

Building a demo webpage using the spark-template-engine https://github.com/perwendel/spark-template-engines/tree/master/spark-template-handlebars

Use the HandleBars Template to build a simple website with:

* An Index Page (index.hbs)
* A submit form and button
* A dynamic sign-in page (sign-in.hbs)
* Cookies to store the username in memory
* Data Access Objects (_Note: The "in memory" simple DAO class should not be used in production in place of a database. It is there simply as a prototype_) 
* A Base.hbs that index and sign-in can inherit from (see http://jknack.github.io/handlebars.java/reuse.html)
* A CSS file with some basic styling
* An ideas page that allows users to submit course ideas
* In order to have a function run on every request prior to any other handler you should you use the before filter.
* Additional information can be stored and retrieved on a request using req.attribute
* The slugify dependency is used to add meaning to URL's that would otherwise be accessed through an ID (https://github.com/slugify/slugify)
