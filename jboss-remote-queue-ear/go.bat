cd ..\jboss-remote-queue-consumer\
call mvn clean install
cd ..\jboss-remote-queue-ear
call mvn clean ear:generate-application-xml ear:ear
copy /Y target\jboss-remote-queue-ear-1.0-SNAPSHOT.ear ..\..\jboss-eap-5.1.2_consumer\jboss-as\server\default\deploy
sleep 3
curl http://localhost:8080/jboss-remote-queue-producer/simple
curl http://localhost:8080/jboss-remote-queue-producer/simple
curl http://localhost:8080/jboss-remote-queue-producer/simple
