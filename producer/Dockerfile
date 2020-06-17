FROM openjdk:8-alpine

#设定接下来COPY命令的执行目录
WORKDIR /app
#找到需要拷贝的jar包
ARG APPJAR=target/producer.jar
COPY ${APPJAR} app.jar

#挂载临时目录
VOLUME /tmp
ENTRYPOINT ["java","-jar","app.jar"]