pipeline {

    agent any

    stages {
        stage('Build springserver') {
              tools {
                   maven "maven"
                   jdk "jdk"
              }
              steps {
                dir('springserver'){
                   sh('mvn clean install')
                }
              }
        }
        stage('Build docker-images') {
              steps {
                  sh('docker-compose build')
              }
        }
    }
}