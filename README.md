# Microprofile Vehicle

A simple microprofile Application with an Apache Derby database.

## How to run the application

### Download the Derbydb

<https://db.apache.org/derby/derby_downloads.html>

### Unzip the database in the /opt - Folder

### Start the database

Create a directory for the db-files. Enter the directory and start the database

```
mkdir db
cd db
/opt/db-derby-10.14.2.0-bin/bin/startNetworkServer -noSecurityManager
```

### Start the application

```
mvn clean thorntail:run
```

or

```
mvn clean package
java -jar target/vehicle-thorntail.jar
```

or

```
mvn clean package && java -jar target/vehicle-thorntail.jar

```

The last line of the log should be:

```
[org.wildfly.swarm] (main) THORN99999: Thorntail is Ready
```

### Smoke tests

```bash
curl http://localhost:8080/api/vehicle/all
curl -d '{"brand":"Opel","model":"Kadett","bodyStyle":"HATCHBACK"}' -H "Content-Type: application/json" -X POST http://localhost:8080/api/vehicle
curl http://localhost:8080/api/vehicle/all
curl http://localhost:8080/api/vehicle/1
curl -X DELETE http://localhost:8080/api/vehicle/id/1
curl  -H "Content-Type: application/json" http://localhost:8080/api/vehicle/all
```

and / or 

check the database. The table VEH_VEHICLE should not be empty.


## Dependencies
 ```
    <dependencies>
        <dependency>
            <groupId>io.thorntail</groupId>
            <artifactId>web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.derby</groupId>
            <artifactId>derbyclient</artifactId>
            <version>10.14.2.0</version>
        </dependency>
        <dependency>
            <groupId>io.thorntail</groupId>
            <artifactId>arquillian</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```
