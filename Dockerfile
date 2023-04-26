# pull base image
FROM eclipse-temurin:17-jdk as build

# define working directory
RUN mkdir aviatickets/
WORKDIR /aviatickets

ARG MAVEN_VERSION=3.9.0
ARG USER_HOME_DIR="/root"
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries
ARG JAR_FILE=target/*.jar

RUN apt-get update

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
 && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
 && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
 && rm -f /tmp/apache-maven.tar.gz \
 && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

# save pom.xml into the image
COPY pom.xml ./

# save source code into the image
COPY src ./src

# install dependencies into the image
RUN mvn clean package

FROM build as run
ARG PROFILE

# copy jar file from build
COPY --from=build aviatickets/target/*.jar aviatickets.jar

EXPOSE 80 8000

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE:default}", "-jar", "aviatickets.jar"]