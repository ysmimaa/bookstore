FROM jenkins/jenkins:2.60.3
LABEL maintainer="youssef.smimaa@gmail.com"
USER root
RUN mkdir -p /var/jenkins_home
RUN chown -R jenkins:jenkins /var/jenkins_home
USER jenkins
ENV JAVA_OPTS="-Xmx2048m"
ENV JENKINS_OPTS=" --handlerCountMax=300 --logfile=/var/jenkins_home/jenkins-log.log"
