pipeline {
   agent any

   environment {
      DOCKER_HUB_CREDENTIALS = credentials('dockerhub-credentials')
   }

   stages {

      stage('Build Image') {
         steps {
           sh '''
           docker build -t mohamedamine/tuto:1.2 .
           '''
         }
      }

      stage('Push Image') {
         steps {
           withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
              sh '''
              docker tag mohamedamine/tuto:1.2 mohamedamine/tuto:1.2
              docker login -u dahechamine -p 12345678sS
              docker push mohamedamine/tuto:1.2
              '''
           }
         }
      }
   }
}
