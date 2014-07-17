set JBOSS_PRODUCER_DEPLOY_LOCATION=%HOME%\workspace\jboss_testing\jboss-eap-patched-5.1.2_producer\jboss-as\server\default\deploy


copy /Y jms-example-service.xml %JBOSS_PRODUCER_DEPLOY_LOCATION%

call mvn clean package
copy /Y target\jboss-remote-queue-producer.war %JBOSS_PRODUCER_DEPLOY_LOCATION%
sleep 3
curl http://localhost:8080/jboss-remote-queue-producer/simple

