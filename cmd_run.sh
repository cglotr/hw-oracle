#!/bin/bash
set -e

mvn -version
mvn package

java -version
java -jar target/hw-oracle-v0.jar server example.yml
