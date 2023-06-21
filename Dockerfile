FROM openjdk:17

# Workspace
WORKDIR /usr/share/workspace

# ADD .jar under target from host
# into this image
ADD target/spring-boot-selenium.jar 			spring-boot-selenium.jar
ADD target/spring-boot-selenium-tests.jar 		spring-boot-selenium-tests.jar
ADD target/libs							libs

#ADD Any other dependencies like suite xml files, .csv / .xls files 

ENTRYPOINT java -cp spring-boot-selenium.jar:spring-boot-selenium-tests.jar:libs/* \
-Dbrowser=chrome \
io.cucumber.core.cli.Main \
classpath:features \
--glue com.udemy.spring.springselenium.bdd \
--tags {"@smoke"} \
--threads 2