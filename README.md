# advert-service-quarkus project

This project uses Quarkus (for more about Quarkus, please visit its website: https://quarkus.io/ ).

## Configure GraalVM

For the local development:

1. Download and install GraalVM Community edition: https://www.graalvm.org/downloads/

2. Set Env Vars by calling these commands:

   - `export GRAALVM_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-java8-20.0.0/Contents/Home`

   - `export JAVA_HOME=${GRAALVM_HOME}`

   - `export PATH=${GRAALVM_HOME}/bin:$PATH`

## Running the application

### Pre-requirements

Launch a postgres instance with advert tables (e.g. by docker-compose in jobengine)

### Running in dev mode

You can run your application in dev mode that enables live coding using:

```
./gradlew quarkusDev
```

or, by Maven, using

```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./gradlew quarkusBuild` (for maven `./mvnw quarkus:build`).
It produces the `advert-service-quarkus-1.0.0-SNAPSHOT-runner.jar` file in the `build` directory (for Maven in the `target` directory).

The application is now runnable using `java -jar build/advert-service-quarkus-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./gradlew buildNative`.
Or, by Maven, using: `./mvnw package -Pnative`

You can then execute your native executable with: `./build/advert-service-quarkus-1.0.0-SNAPSHOT-runner`

If you don't have GraalVM installed, you can run the native executable build in a container using: `./gradlew buildNative --docker-build=true`
(for Maven `./mvnw package -Pnative -Dquarkus.native.container-runtime=docker`)

Or directly:
`docker build -f src/main/docker/Dockerfile.native -t quarkus/advert-service-quarkus .`

Or, in case of Docker container, by:
`docker run -i --rm -p 8080:8080 quarkus/advert-service-quarkus`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling#building-a-native-executable.
(for Maven https://quarkus.io/guides/building-native-image).

### For Local by MAC composition of Docker native image

Because the native image is composed with Mac/OS format, it's not possible launch it from a Linux Docker machine. For doing this, we need to produce the native image using a specific Docker container.

For building the environment:

`docker build -f src/main/docker/Dockerfile.graal -t quarkus/graal-native-image .`

For producing the native image:

`docker run -it -v /Users/gianluca.moretti/Workspaces/demo/demoQuarkus/quarkus-advertservice:/project --rm quarkus/graal-native-image`

After that, the native image file is ready in the build/target folder. It's ready to be added in a Ubuntu Docker machine by using this command:

`docker build -f src/main/docker/Dockerfile.native -t quarkus/advert-service-quarkus .`

The Docker image could be lauched using this command:

`docker run -i --rm -p 8080:8080 quarkus/advert-service-quarkus`
