=================================
== Acegi Samples application ==
=================================

@author ShriKant

Users with technician or admin role can access this application. The default implementation
uses /WEB-INF/users.properties (contains userid/password and role info) for authentication. Similarly 
authorization information is specified in applicationContext-acegi-security.xml with 
"filterInvocationInterceptor" bean definition.

Changing authentication implementation from default to external service based
-----------------------------------------------------------------------------
Custom AuthenticationProvide is implemented with 
com.abc.security.authentication.ABCSecurityAuthenticationProvider class which internally calls 
UserAuthenticationService as authentication service. To configure
the same in this application, you need to comment existing "daoAuthenticationProvider" bean definition and
uncomment the bean definitions between "Custom AuthenticationProvider implementation starts here" and 
"Custom AuthenticationProvider implementation ends here". Please note that userid/password and role information
remains same as mentioned in /WEB-INF/users.properties but custom authentication implementation 
doesn't use it anymore. As a result you can use the same userid/password which you used earlier.

Dynamic authorization implementation using memory datasource (can be changed to database)
-----------------------------------------------------------------------------------------

Authorization also can be externalized and can be made dynamic by using database. To implement the same
we have implemented FilterInvocationDefinitionSource 
(com.abc.security.authorization.DatabaseDrivenFilterInvocationDefinitionSource) which uses a service to get
the authorization information corresponding to a secured resource. To change the default authorization 
implementation to database based implementation we need to make following changes in 
applicationContext-acegi-security.xml.

Comment existing "filterInvocationInterceptor" bean definition and uncomment the bean definitions between
"Custom filterInvocationInterceptor implementation starts here" and 
"Custom filterInvocationInterceptor implementation ends here" XML comments.

Installation
============

The URL for the application -- http://localhost:8080/acegisamples/
To access the application use the userid/password mentioned in WEB-INF/users.properties.

Tomcat Deployment
-----------------

Configuration
-------------
1. Change appserver.home and env.CATALINA_HOME in build.properties. Also specify userid/password for 
Tomcat manager there. For this application Tomcat 5.5.9 has been used
2. In build.bat change ANT_HOME.

For deploying the application on Tomcat for the first time
----------------------------------------------------------
1. Run tomcat.
2. Run following ANT targets in the order specified below:
	a)clean
	b)build	
	c)deploy
	
	or just execute build.bat on command prompt.


Making the changes in Java classes, deploying the application and restarting the Tomcat
------------------------------------------------------------------------------------
1. Tomcat should be up and running.
2. Run following ANT targets in the order specified below:
	a) stop
	c) build
	c) undeploy 
	d) deploy 
	e) start
