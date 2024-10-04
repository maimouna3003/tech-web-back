FROM alpine/java:22-jdk
EXPOSE 2323
COPY unchk-0.0.1-SNAPSHOT.jar /home/unchk-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/unchk-0.0.1-SNAPSHOT.jar"]