FROM jenkins
COPY plugins.txt /usr/share/jenkins/plugins.txt
ENV JENKINS_OPTS --prefix=/jenkins
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
