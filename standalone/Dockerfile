FROM debian:jessie
RUN echo "deb http://ftp.debian.org/debian jessie-backports main" >> /etc/apt/sources.list
RUN apt-get update
RUN apt-get install wget -y
RUN apt-get -t jessie-backports install openjdk-8-jre -y
RUN wget https://github.com/yahoo/pulsar/releases/download/v1.15.2/pulsar-1.15.2-bin.tar.gz
RUN tar zxvf pulsar-1.15.2-bin.tar.gz
EXPOSE 8080
WORKDIR /pulsar-1.15.2
CMD ./bin/pulsar standalone

