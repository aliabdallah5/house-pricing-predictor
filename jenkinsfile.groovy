pipeline {
   agent any

   triggers {
        pollSCM "*/5 * * * *"
    }

   stages {

      stage('Build Image') {
         steps {
           withCredentials([usernamePassword(credentialsId: '39f96646-101f-41c0-bf74-6a75c3e95a48	', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
               script {
                   docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                       def image = docker.build("mohamedamine/tuto:1.2", ".")
                       image.push()
                   }
               }
           }
         }
      }
   }
}
