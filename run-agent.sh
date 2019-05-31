nohup java \
-javaagent=/home/bocloud/skywalking/agent/skywalking-agent.jar \
-Dagent.application_code=$2 \
-jar $1 > $2.log &