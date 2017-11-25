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
        stage('Build springserver image') {
              steps {
                dir('springserver'){
                    sh('docker build -t eu.gcr.io/devopseksamen/springserver:v2 .')
                  }
              }
              steps {
                dir('documentation-viewer'){
                    sh('docker build -t eu.gcr.io/devopseksamen/documentationviewer:v2 .')
                }
              }
        }
    }
}