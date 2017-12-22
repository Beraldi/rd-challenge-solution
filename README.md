Welcome to RD Challenge Solution!
===================

Heroku links:
> [rd-challenge-solution-app][1]

> [rd-challenge-solution-site][2]

> [rd-challenge-solution-ui][3]

[1]: https://rd-challenge-solution-app.herokuapp.com/

[2]: https://rd-challenge-solution-site.herokuapp.com/

[3]: https://rd-challenge-solution-ui.herokuapp.com/

How to run local:

There are three folders at the root of the project:
> web-application

> site-exemplo

> web-application-ui

*web-application*
-------------
To run this application a little more attention is needed.
You will need a mysql database named **rd-challenge-db**.
In the root of the folder you will find the folder **db / ddl / 1.0.0** and two files **01-create-user.sql** and **02-create-cookie.sql**.
These are the two tables that will be created in your database.
After creating them go to **/ src / main /** resources and in the file **application.properties** configure the credentials of your database.

Once done, at the root of the project by the terminal run:
**$ mvn spring-boot: run**

*site-example*
-------------
This is an ordinary site. Here you'll find the tracking tag and contact form.
To execute it simply enter in root via terminal and enter the following command:
**$ gulp browserSync**

*web-application-ui*
-------------
Here you have the result of the navigations made by the users. At first I used ELK stack to replace this project and mysql. That way we could have scalability and better searches. But developing that part made the project a little more attractive to better show my coding.
In this step, go to the root in the project and type in the terminal:
**$ npm install && nodemon server.js**

> **Tip:** You will need to have java, maven, nodejs and npm installed and configured.
