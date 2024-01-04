FROM tomcat
COPY target/newapp.war /usr/local/tomcat/webapps/
