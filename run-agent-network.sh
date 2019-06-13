#!/usr/bin/env bash
JENKINS_NODE_COOKIE=dontKillMe \
nohup java \
-javaagent:/home/bocloud/skywalking/agent/skywalking-agent.jar \
-Dskywalking.agent.application_code=$2 \
-Dspring.profiles.active=test \
-Dserver.address=172.18.0.1 \
-jar $1 > $2.log & echo $!  >> pid