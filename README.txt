Sample Web Service and RESTful sample with Spring3.1, Apache CXF, JPA, Hibernate4.1
----------------------------------------
1.  Install Maven and Java
2.  On the Root Directory run  "mvn clean install"
3.  Then run "mvn tomcat:run-war" to startup the server
4.  You can access the webapp with:  

http://localhost:8080/hnl-ws-spring-jpa-hibernate/

You should see a table view of the web services as well as RestFul Service.  
Click on the link and it should bring up the running services.  
For the RESTful time servie it will print out current time.

Note: The default database is in memory DB using HSQL.  To switch your datasource please see filters/fiters-dev.properties