FROM gradle:4.0-jdk8 AS BUILD_IMAGE
USER root
ENV APP_HOME=/project/
RUN mkdir -p $APP_HOME
WORKDIR $APP_HOME
COPY build.gradle .
COPY gradle gradle
RUN ls -R
RUN gradle build -x :bootRepackage -x test --continue
COPY . .
RUN ls -alR /project
RUN gradle build  -x test --info
RUN ls -R

FROM turo/java-app
WORKDIR /root/
COPY --from=BUILD_IMAGE /project/build/libs/cf-example-*.jar app.jar
