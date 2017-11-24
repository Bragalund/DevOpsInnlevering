pipeline {

    agent any

    stages {
        stage('Test springserver') {
             tools {
                 maven "maven"
                 jdk "jdk"
             }
             steps {
               dir('springserver'){
                 sh('mvn clean test')
               }
             }
        }

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
        stage('Deploy') {
              steps {
                dir('ansible'){
                  sh('ansible-playbook deploy-playbook.yml')
                }
              }
        }


    }
}