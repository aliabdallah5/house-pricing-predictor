pipeline {
   agent any

   triggers {
        pollSCM "*/5 * * * *"
    }

   stages {

      stage('Build Image') {
         steps {
           bat '''
           docker build -t mohamedamined/tuto:1.2 .
           '''
         }
      }

      stage('Push Image') {
         steps {
           bat '''
           docker tag mohamedamined/tuto:1.2 mohamedamined/tuto:1.2
           docker login -u dahechamine -p 12345678sS
           docker push allayayahya/tuto:1.2
           '''
         }
      }

   }
}

