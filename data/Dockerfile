FROM busybox
RUN adduser -S -u 200 nexus --home /sonatype-work
RUN adduser --disabled-password -u 1000 jenkins --home /var/jenkins_home
CMD tail -f /dev/null
