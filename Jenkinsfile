pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    environment {
        NEW_VERSION = '1.3.0'
    }
    stages {
        stage("build") {
            steps {
               echo "building the application with version as ${NEW_VERSION}"
            }
        }

        stage("test") {
            steps {
                echo 'Running the tests for the application'
            }
        }

        stage("deploy") {
            steps {
                 echo 'Deploying the application'
            }
        }
    }
}