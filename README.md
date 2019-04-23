# Java Spring twitter demo

This project can be ran with mvn spring-boot:run, and is set to run on port 5012.

* Configuration
  * The project requires access to a database to function properly. You should make changes to the application.properties file found in
/src/main/resources to match your sql username and password. You can also change the port the application runs on from here.
  * You should also replace the 'cinf201_gkline' in jdbc:mysql://localhost:3306/cinf201_gkline (also found in application.properties)
with the database you would like to use.
  * Tables for the database will be created automatically.

Once the application is running, navigating to localhost:5012 should prompt you with a login screen. Before accessing this page, you need
to register an account at localhost:5012/register.

