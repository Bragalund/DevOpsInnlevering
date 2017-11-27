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
                    sh('docker build -t eu.gcr.io/devopseksamen/springserver:${BUILD_NUMBER} .')
                  }
              }
        }
        stage('Build documentation-viewer image'){
              steps {
                dir('documentation-viewer'){
                    sh('docker build -t eu.gcr.io/devopseksamen/documentationviewer:${BUILD_NUMBER} .')
                }
              }
        }
        stage('Deploy app') {
            steps {
                    sh('gcloud auth activate-service-account --key-file /home/ubuntu/DevOpsEksamen-fd8bbc5d8acd.json')
                    sh('gcloud config set project devopseksamen')
                    sh('gcloud config set compute/zone europe-west3-a')
                    sh('gcloud docker -- push eu.gcr.io/devopseksamen/springserver:${BUILD_NUMBER}')
                    sh('gcloud container clusters get-credentials dev-ops-cluster --zone europe-west3-a --project devopseksamen')
                    sh('kubectl set image deployment/springserver springserver=eu.gcr.io/devopseksamen/springserver:${BUILD_NUMBER}')
                    sh('gcloud container clusters resize dev-ops-cluster --size 1 -y')
                    sh('gcloud container clusters resize dev-ops-cluster --size 3 -y')

            }
        }
        stage('Clean up after deploy') {
            tools {
                    maven "maven"
                    jdk "jdk"
            }
            steps {
              dir('springserver') {
                   sh('mvn clean')
              }
            }
        }

    }
}