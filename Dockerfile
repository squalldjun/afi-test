FROM openjdk:17.0.2
WORKDIR /workdir
COPY target/afi-test-0.0.1-SNAPSHOT.jar ./app.jar

ENV JAVA_OPTIONS="-Xms128m -Xmx256m -XX:+UseG1GC -XX:MaxMetaspaceSize=64m -XX:MaxTenuringThreshold=0"

EXPOSE 8088
CMD java ${JAVA_OPTIONS} -jar app.jar
