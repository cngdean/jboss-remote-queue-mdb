call mvn clean package ear:generate-application-xml ear:ear
copy /Y target\jboss-remote-queue-consumer.ear ..\..\jboss-eap-5.1.2_consumer\jboss-as\server\default\deploy
sleep 3
curl http://localhost:8180/jboss-remote-queue-consumer/simple
