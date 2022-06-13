FROM ghcr.io/graalvm/graalvm-ce:latest AS builder

ADD . /build
WORKDIR /build

# For SDKMAN to work we need unzip & zip
RUN microdnf install -y unzip zip

RUN \
    # Install SDKMAN
    curl -s "https://get.sdkman.io" | bash; \
    source "$HOME/.sdkman/bin/sdkman-init.sh"; \
    # Install Maven
    sdk install maven; \
    # Install GraalVM Native Image
    gu install native-image;

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && mvn --version

RUN native-image --version

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && cd petstore-service && ./compile.sh


# We use a Docker multi-stage build here so that we only take the compiled native Spring Boot app from the first build container
FROM oraclelinux:7-slim

MAINTAINER cmauri@gmail.com

# Add Spring Boot Native app spring-boot-graal to Container
COPY --from=0 "/build/petstore-service/target/petstore-service" app

# Fire up our Spring Boot Native app by default
CMD [ "sh", "-c", "./app" ]
