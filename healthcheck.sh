#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

#echo "Checking if hub is ready - $HUB_HOST"
#
#while [ "$( curl -s http://$HUB_HOST:4444/ui | jq -r .value.ready )" != "true" ]
#do
#	sleep 1
#done

# start the java command
java -cp spring-boot-selenium.jar:spring-boot-selenium-tests.jar:libs/* \
    -DHUB_HOST=$HUB_HOST \
    -DBROWSER=$BROWSER \
    io.cucumber.core.cli.Main \
    classpath:features \
    --tags $TAGS \
	  --glue com.udemy.spring.springselenium.bdd \
	  --threads 2

