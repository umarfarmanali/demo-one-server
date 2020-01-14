pipeline {
    
    agent any
    
    stages {
        stage('CLean') {
           steps {
               sh 'mvn clean'
               
           }
        }
        stage('Validate') {
           steps {
               sh 'mvn validate'
               
           }
        }
        stage('Compile') {
           steps {
               sh 'mvn compile'
               
           }
        }
       stage('Test') {
           steps {
               sh 'mvn test'
           }
        }
        stage('Package') {
           steps {
               sh 'mvn package'
           }
        }
        stage('Verify') {
           steps {
               sh 'mvn verify'
           }
        }
        stage('Deploy'){
            steps{
        		sh 'mvn deploy'
            }
        }
    }
}