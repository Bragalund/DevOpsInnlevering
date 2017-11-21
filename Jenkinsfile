pipeline {

    agent any

    stages {
        stage('Build') {
            dir('springserver')
            tools {
                    maven "maven"
                    jdk "jdk"
                }
            steps {
               sh('mvn clean install')
            }
        }
    }
}