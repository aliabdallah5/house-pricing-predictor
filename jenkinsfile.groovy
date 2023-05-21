pipeline {
   agent any

   triggers {
        pollSCM "*/5 * * * *"
    }

   stages {

      stage('Build Image') {
         steps {
           withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
               sh '''
               docker build -t mohamedamine/tuto:1.2 .
               '''
           }
         }
      }

      stage('Push Image') {
         steps {
           withCredentials([usernamePassword(credentialsId: '6fb88174-6d35-460d-aaa0-05886517b720', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
               sh '''
               docker tag mohamedamine/tuto:1.2  mohamedamine/tuto:1.2
               docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
               docker push mohamedamine/tuto:1.2
               '''
           }
         }
      }

   }
}



