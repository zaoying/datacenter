JENKINS_NODE_COOKIE=dontKillMe nohup java \
-javaagent:/home/bocloud/skywalking/agent/skywalking-agent.jar \
-Dskywalking.agent.application_code=$2 \
-jar $1 > $2.log &