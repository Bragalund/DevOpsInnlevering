pipeline {

    agent any

    stages {
        stage('Build') {
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
    }
}