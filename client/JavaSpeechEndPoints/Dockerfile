FROM resin/rpi-raspbian:wheezy

COPY raspberrypi.gpg.key /key/
RUN echo 'deb http://archive.raspberrypi.org/debian/ wheezy main' >> /etc/apt/sources.list.d/raspi.list && \
    echo oracle-java8-jdk shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-key add /key/raspberrypi.gpg.key

RUN apt-get update && \
    apt-get -y install oracle-java8-jdk && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

EXPOSE 1521 80

WORKDIR /

ADD . /App/
RUN mv /App/run.sh /run.sh

CMD java -web -webAllowOthers -webPort 80 -tcp -tcpAllowOthers -tcpPort 1521 -baseDir /opt/h2-data

CMD ["/bin/bash", "-ex", "run.sh"]