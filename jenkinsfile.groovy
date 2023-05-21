pipeline {
   agent any

   triggers {
        pollSCM "*/5 * * * *"
    }

   stages {

      stage('Build Image') {
         steps {
           withCredentials([usernamePassword(credentialsId: '6fb88174-6d35-460d-aaa0-05886517b720', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
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
