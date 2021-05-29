# Active-Record-Pattern

La nueva tarea de este sprint es pasar el repositorio antiguo de getting-started a un Active record pattern,
usando MariaDB dockerizado y usando la propia clase del objeto que almacenamos en la base de datos a modo de repositorio
usando Panache, en lugar de usar un entityManager.
Usa este comando para generar un contenedor de MariaDB con las variables 
de entorno necesarias para conectarla a la API Rest.

```
docker run -ti --rm -e MYSQL_ROOT_PASSWORD=developer -e MYSQL_USER=developer -e MYSQL_PASSWORD=developer -e MYSQL_DATABASE=espadas -p 3000:3306 mariadb:latest
```

Acto seguido ejecuta este comando para iniciar la API en modo desarrollo en el puerto 8080 de tu localhost
```
.\mvnw compile quarkus:dev
```

Los casos tests están preparados para un despliegue automático en contenedores docker. Usa alguno de estos comandos para ejecutarlos todos o solo un modulo en especifico.
```
.\mvnw -Dtest="EspadaResourceTest" test
```
```
.\mvnw -Dtest="EspadaServiceTest" test
```
```
.\mvnw -test
```
Soy consciente de que el repo tenia tematica de frutas originalmente, pero como me estoy leyendo [Berserk](https://es.wikipedia.org/wiki/Berserk_(manga)),
escrito por Kentaro Miura (DEP), y el prota es famoso por su caracteristica espada Dragonslayer 
decidí usar esta temática.

# getting-started project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/getting-started-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
