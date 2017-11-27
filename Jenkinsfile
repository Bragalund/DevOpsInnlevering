pipeline {

    agent any

    stages {
        stage('Instal programs with ansible'){
            steps {
              dir('ansible'){
                sh('ansible-playbook -i "localhost," -c local main.yml')
              }
            }
        }
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
        stage('Build springserver image') {
              steps {
                dir('springserver'){
                    sh('docker build -t eu.gcr.io/devopseksamen/springserver:v3 .')
                  }
              }
        }
        stage('Build documentation-viewer image'){
              steps {
                dir('documentation-viewer'){
                    sh('docker build -t eu.gcr.io/devopseksamen/documentationviewer:v3 .')
                }
              }
        }
        stage('Deploy app') {
            steps {
              dir('ansible') {
                    sh('ansible-playbook -i "localhost," -c local deploy.yml')
                }
            }
        }
        stage('Clean up after deploy') {
            tools {
                             maven "maven"
            }
            steps {
              dir('springserver') {
                   sh('mvn clean')
              }
            }
        }

    }
}