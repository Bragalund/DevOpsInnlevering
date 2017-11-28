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
                    sh('docker build -t eu.gcr.io/${DEV_OPS_PROJECT_ID}/springserver:${BUILD_NUMBER} .')
                  }
              }
        }
        stage('Deploy app') {
            steps {
                    sh('gcloud auth activate-service-account --key-file /home/ubuntu/${SECRET_FILE_NAME}')
                    sh('gcloud config set project ${DEV_OPS_PROJECT_ID}')
                    sh('gcloud config set compute/zone ${DEV_OPS_ZONE}')
                    sh('gcloud docker -- push eu.gcr.io/${DEV_OPS_PROJECT_ID}/springserver:${BUILD_NUMBER}')
                    sh('gcloud container clusters get-credentials ${DEV_OPS_CLUSTER} --zone ${DEV_OPS_ZONE} --project ${DEV_OPS_PROJECT_ID}')
                    sh('kubectl set image deployment/springserver springserver=eu.gcr.io/${DEV_OPS_PROJECT_ID}/springserver:${BUILD_NUMBER}')
                    sh('gcloud container clusters resize ${DEV_OPS_CLUSTER} --size 1 --quiet')
                    sh('gcloud container clusters resize ${DEV_OPS_CLUSTER} --size 3 --quiet')

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