pipeline {
  agent any
  tools {
    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'DOCKER_HOME'
  }
  stages {
    stage('Build app with maven') {
      steps {
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
    stage('push image to local docker') {
      steps{
        sh 'docker tag afi-test:1.0.0 192.168.18.26:2375/afi-test:1.0.0';
      }
    }
  }
}
