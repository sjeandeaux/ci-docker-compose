FROM jenkins/jenkins:2.138.1-slim

ENV JENKINS_USER=oncle JENKINS_PASSWORD=bens

COPY config/*.override /usr/share/jenkins/ref/
COPY script/*.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY maven-settings.xml /tmp/maven-settings.xml

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

ENV JENKINS_OPTS --prefix=/jenkins
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false -Djava.awt.headless=true "
