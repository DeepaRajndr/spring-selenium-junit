FROM openjdk:17

# Workspace
WORKDIR /usr/share/workspace

# ADD .jar under target from host
# into this image
ADD target/spring-boot-selenium.jar 			spring-boot-selenium.jar
ADD target/spring-boot-selenium-tests.jar 		spring-boot-selenium-tests.jar
ADD target/libs							        libs

#ADD Any other dependencies like suite xml files, .csv / .xls files 

# ADD health check script
ADD healthcheck.sh                      healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh
