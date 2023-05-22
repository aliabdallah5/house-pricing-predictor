pipeline {
   agent any

   triggers {
        pollSCM "*/5 * * * *"
    }

   stages {

      stage('Build Image') {
         steps {
           bat '''
           docker build -t dahechamine/test3 .
           '''
         }
      }

      stage('Push Image') {
         steps {
           bat '''
           docker tag dahechamine/test3 dahechamine/test3
           docker login -u dahechamine -p 12345678sS
           docker push dahechamine/test3
           '''
         }
      }

   }
}

