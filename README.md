Install jenkins and create pipeline for build and deploy application :

- Download docker image for jenkins<br />
  docker pull jenkins/jenkins
  
- Run jenkins image, [documentation](https://www.jenkins.io/doc/book/installing/docker/) <br />
  docker run -d -it --name jenkins-2472 --user root -p 8080:8080 -p 50000:50000 -v /var/run/docker.sock:/var/run/docker.sock -v C:\Users\USER\Documents\tools\jenkins:/var/jenkins_home jenkins/jenkins:latest
  
- Login to jenkins and install plugins (Manage Jenkins > Plugins > Available plugins)
  1. pipeline maven integration
  2. docker commons
  
- Config maven and docker (Manage Jenkins > Tools)

- Create pipeline (Dashboard > New Item)
  1. choose pipeline
  2. copy script from file pipeline.groovy into pipeline<br />
     process inside groovy is git pull, maven install, docker build and run
  
- Wait until jenkins job finish and check.
