pipeline {
   agent any

   triggers {
        pollSCM "*/5 * * * *"
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
           sh '''
           docker tag mohamedamine/tuto:1.2  mohamedamine/tuto:1.2
           docker login -u dahechamine -p 23714406sS
           docker push mohamedamine/tuto:1.2
           '''
         }
      }

   }
}
