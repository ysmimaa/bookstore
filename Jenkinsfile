pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Launching building '
      }
    }

    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            echo 'Launching unit tests'
          }
        }

        stage('Integration test') {
          steps {
            echo 'Launching integration test'
          }
        }

      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploying app'
      }
    }

    stage('Dockerizing') {
      steps {
        echo 'Dockerizing the app '
      }
    }

  }
}