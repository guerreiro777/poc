#FROM mysql
#ENV MYSQL_DATABASE poc
#COPY ./database/ /docker-entrypoint-initdb.d/


FROM openjdk:11
VOLUME /tmp
EXPOSE 8180
#RUN ./gradlew build
ADD ./build/libs/poc.jar poc.jar

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait
CMD /wait

ENTRYPOINT ["java","-jar","poc.jar"]
