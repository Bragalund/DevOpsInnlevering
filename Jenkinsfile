pipeline {

    agent any

    stages {
        stage('Build') {
            tools {
                    maven "maven"
                    jdk "jdk"
                }
            steps {
               sh('cd ./springserver')
               sh('mvn clean install')
            }
        }
    }
}