# 使用 OpenJDK 作为基础镜像
FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/todonow.war app.war
ENTRYPOINT ["java", "-jar", "/app.war"]
