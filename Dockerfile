FROM openjdk:11
VOLUME /tmp
EXPOSE 8180
ADD ./build/libs/cateno.jar cateno.jar

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait
CMD /wait

ENTRYPOINT ["java","-jar","cateno.jar"]
