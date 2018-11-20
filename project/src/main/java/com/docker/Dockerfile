FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD springboot-web.jar SpringbootWebApplication.jar
RUN sh -c 'touch /SpringbootWebApplication.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]