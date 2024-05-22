# Example 

## Build

```shell
mvn clean verify
```

## Run

```shell
java -jar payara-micro-6.2024.5.jar --deploy web-module/target/web-module-1.0-SNAPSHOT.war \
  --addlibs ejb-library/target/ejb-module-library-1.0-SNAPSHOT.jar:ejb-module/target/ejb-module-1.0-SNAPSHOT.jar
```