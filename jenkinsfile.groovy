pipeline {
   agent any

   triggers {
        pollSCM "*/5 * * * *"
    }

   stages {

      stage('Build Image') {
         steps {
           bat '''
           docker build -t mohamedamined/test3 .
           '''
         }
      }

      stage('Push Image') {
         steps {
           bat '''
           docker tag mohamedamined/test3 mohamedamined/test3
           docker login -u dahechamine -p 12345678sS
           docker push mohamedamined/test3
           '''
         }
      }

   }
}

