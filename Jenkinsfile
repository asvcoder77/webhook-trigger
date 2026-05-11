pipeline {
    agent any

    stages {

        stage('Build Jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image') {
            steps {
                bat 'docker build -t vishnu7as/orange:latest .'
            }
        }

        stage('Push Image') {
            environment {
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps {
                bat '''
                echo %DOCKER_HUB_PSW% | docker login -u %DOCKER_HUB_USR% --password-stdin
                docker push vishnu7as/orange:latest
                docker tag vishnu7as/orange:latest vishnu7as/orange:%BUILD_NUMBER%
                docker push vishnu7as/orange:%BUILD_NUMBER%
                '''
            }
        }
    }

    post {
        always {
            bat 'docker logout'
        }
    }
}