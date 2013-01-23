Spring/GWT Atmosphere Integration Sample
=========================

This repository illustrates integration scenarios for [Atmosphere], between a GWT front end and a Spring MVC Restful server side. 
The following 2 samples are provided:

1. spring-mvc-atmosphere-sample - Spring MVC project with [Atmosphere] servlet enabled.
2. AtmosphereGWT - GWT front end project to connect to project above.

Tested using Eclipse 3.7 (Indigo), Tomcat 7.0.30

Tomcat server - you can change the connector in the server.xml to the following:
<Connector connectionTimeout="600000" port="8080" protocol="org.apache.coyote.http11.Http11NioProtocol" redirectPort="8443"/>

Setup:
1. Clone this repository
2. Import existing maven projects into eclipse
3. Add both projects above to your tomcat installation.
4. Start tomcat
5. Open browser, and point to http://localhost:8080/AtmosphereGWT/ 
6. Use Chrome dev tools to see if websocket connect succeeded 

7. See TestPresenter.java, this contains the code to connect to the atmosphere servlet. Currently not working, help needed!! 

[Atmosphere]: https://github.com/Atmosphere/atmosphere

