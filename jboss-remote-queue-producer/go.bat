call mvn clean package
copy /Y target\jboss-remote-queue-producer.war ..\..\jboss-eap-5.1.2_producer\jboss-as\server\default\deploy
sleep 3
curl http://localhost:8080/jboss-remote-queue-producer/simple

