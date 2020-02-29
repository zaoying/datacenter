#/bin/bash
docker build -t datacenter-eureka:latest eureka
docker build -t datacenter-school:latest school
docker build -t datacenter-student:latest student
docker build -t datacenter-teacher:latest teacher
docker build -t datacenter-zuul:latest zuul
# docker build -t datacenter-zipkin:latest zipkin