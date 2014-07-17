set JBOSS_CONSUMER_DEPLOY_LOCATION=%HOME%\workspace\jboss_testing\jboss-eap-patched-5.1.2_consumer\jboss-as\server\default\deploy

copy /Y jms-example-service.xml %JBOSS_CONSUMER_DEPLOY_LOCATION%
cd ..\jboss-remote-queue-consumer\
call mvn clean install
cd ..\jboss-remote-queue-ear
call mvn clean ear:generate-application-xml ear:ear
copy /Y target\jboss-remote-queue-ear-1.0-SNAPSHOT.ear %JBOSS_CONSUMER_DEPLOY_LOCATION%
sleep 3
curl http://localhost:8080/jboss-remote-queue-producer/simple
curl http://localhost:8080/jboss-remote-queue-producer/simple
curl http://localhost:8080/jboss-remote-queue-producer/simple
