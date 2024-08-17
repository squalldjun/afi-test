pipeline {
  agent any
  tools {
    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'DOCKER_HOME'
  }
  stages {
    stage('Build app with maven') {
      steps {
        sh 'git init'
        sh 'git config --global --add safe.directory /var/jenkins_home/workspace/pipeline1'
        sh 'git pull https://github.com/squalldjun/afi-test';
        withMaven(maven: 'MAVEN_HOME') {
          sh 'mvn clean install';
        }
      }
    }
    stage('Build app image with docker') {
      steps{
        sh 'docker build -t afi-test:1.0.0 .';
      }
    }
    stage('run docker') {
      steps{
        sh 'docker run --name afi-test -d -it -p 8088:8088 afi-test:1.0.0';
      }
    }
  }
}
