#!/bin/sh
sed -i -e "s;advertisedAddress=;advertisedAddress=$BROKER_HOST;" /pulsar-1.15.2/conf/standalone.conf
./bin/pulsar standalone
