# pulsar-docker

PulsarをDockerコンテナで使う

# Usage

```
$ docker run -d \
        -p 8080:8080 -p 6650:6650 \
        --env BROKER_HOST=192.168.99.100 \
        laclefyoshi/pulsar-docker-standalone

$ docker ps
CONTAINER ID        IMAGE                                  COMMAND                  CREATED             STATUS              PORTS                                            NAMES
dcf1f1c49173        laclefyoshi/pulsar-docker-standalone   "/bin/sh ./start_puls"   6 seconds ago       Up 5 seconds        0.0.0.0:6650->6650/tcp, 0.0.0.0:8080->8080/tcp   kickass_kowalevski
```

```
$ java -cp target/pulsar-client-example-1.0-SNAPSHOT.jar \
       org.saekiyoshiyasu.PulsarProducer http://192.168.99.100:8080
$
```

```
$ java -cp target/pulsar-client-example-1.0-SNAPSHOT.jar \
       org.saekiyoshiyasu.PulsarConsumer http://192.168.99.100:8080

Received message: Hello 0
Received message: Hello 1
Received message: Hello 2
Received message: Hello 3
Received message: Hello 4
Received message: Hello 5
Received message: Hello 6
Received message: Hello 7
Received message: Hello 8
Received message: Hello 9
```
