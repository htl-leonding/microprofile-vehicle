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
mvn thorntail:run
```

The last line of the log should be:

```
[org.wildfly.swarm] (main) THORN99999: Thorntail is Ready
```

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
